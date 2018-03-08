/**
 * Project Name		:	manager-project
 * File Name		:	MyShiroRealm.java
 * Package Name		:	com.longke.manager.project.config.shiro
 * Date				:	2018年3月1日上午9:24:05
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.config.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;

import com.longke.manager.project.entity.generator.SysResources;
import com.longke.manager.project.entity.generator.SysUser;
import com.longke.manager.project.service.system.SystemResourcesService;
import com.longke.manager.project.service.system.SystemUserService;

/**
 * ClassName		:	MyShiroRealm <br/>
 * Function			:	自定义shiro权限认证. <br/>
 * Reason			:	重写用户认证和权限获取信息. <br/>
 * Date				:	2018年3月1日 上午9:24:05 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class MyShiroRealm extends AuthorizingRealm {

	/**
	 * 自动注入用户信息服务接口
	 */
	@Resource
    private SystemUserService systemUserService;

	/**
	 * 自动资源服务接口
	 */
    @Resource
    private SystemResourcesService systemResourcesService;

    /**
     * 自动注入缓存接口
     */
    @Autowired
    private RedisSessionDAO redisSessionDAO;

    /**
     * 
     * 授权权限
     *
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();//User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid",sysUser.getId());
        List<SysResources> resourcesList = systemResourcesService.loadUserResources(map);
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(SysResources resources : resourcesList){
            info.addStringPermission(resources.getResurl());
        }
        return info;
    }

    /**
     * 
     * 账号认证
     *
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        SysUser sysUser = systemUserService.selectByUsername(username);
        if(sysUser == null) {
        	throw new UnknownAccountException();
        } 
        if (0 == sysUser.getEnable()) {
            throw new LockedAccountException(); // 帐号锁定
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		sysUser, //用户
        		sysUser.getPassword(), //密码
                ByteSource.Util.bytes(username),
                getName()  //realm name
        );
        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", sysUser);
        session.setAttribute("userSessionId", sysUser.getId());
        return authenticationInfo;
    }

    /**
     * 
     * clearUserAuthByUserId		:	(根据userId 清除当前session存在的用户的权限缓存). <br/>
     *
     * @author					:	Alex Hu
     * @param userIds			:	已经修改了权限的userId
     * @since					:	JDK 1.8
     */
    public void clearUserAuthByUserId(List<Integer> userIds){
        if(null == userIds || userIds.size() == 0)	return ;
        //获取所有session
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        //定义返回
        List<SimplePrincipalCollection> list = new ArrayList<SimplePrincipalCollection>();
        for (Session session:sessions){
            //获取session登录信息。
            Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if(null != obj && obj instanceof SimplePrincipalCollection){
                //强转
                SimplePrincipalCollection spc = (SimplePrincipalCollection)obj;
                //判断用户，匹配用户ID。
                obj = spc.getPrimaryPrincipal();
                if(null != obj && obj instanceof SysUser){
                	SysUser sysUser = (SysUser) obj;
                    System.out.println("user:" + sysUser);
                    //比较用户ID，符合即加入集合
                    if(null != sysUser && userIds.contains(sysUser.getId())){
                        list.add(spc);
                    }
                }
            }
        }
        RealmSecurityManager securityManager =
                (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm realm = (MyShiroRealm)securityManager.getRealms().iterator().next();
        for (SimplePrincipalCollection simplePrincipalCollection : list) {
            realm.clearCachedAuthorizationInfo(simplePrincipalCollection);
        }
    }
}
