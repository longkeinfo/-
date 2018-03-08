/**
 * Project Name		:	manager-project
 * File Name		:	ShiroConfig.java
 * Package Name		:	com.longke.manager.project.config
 * Date				:	2018年3月1日上午9:16:42
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.config;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.util.StringUtil;
import com.longke.manager.project.config.shiro.MyShiroRealm;
import com.longke.manager.project.entity.generator.SysResources;
import com.longke.manager.project.service.system.SystemResourcesService;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * ClassName		:	ShiroConfig <br/>
 * Function			:	Shiro权限配置文件. <br/>
 * Reason			:	. <br/>
 * Date				:	2018年3月1日 上午9:16:42 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Configuration
public class ShiroConfig {
	/**
	 * 自动注入系统资源服务接口
	 */
	@Autowired(required = false)
	private SystemResourcesService systemResourcesService;

	/**
	 * 读取配置文件中的缓存地址
	 */
	@Value("${spring.redis.host}")
	private String host;

	/**
	 * 读取配置文件中的缓存端口
	 */
	@Value("${spring.redis.port}")
	private int port;

	/**
	 * 读取配置文件中的缓存超时时间
	 */
	@Value("${spring.redis.timeout}")
	private int timeout;

	/**
	 * 读取配置文件中的缓存链接密码
	 */
	@Value("${spring.redis.password}")
	private String password;

	/**
	 * 
	 * shiroDialect		:	(负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。). <br/>
	 * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类.<br/>
	 * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。.<br/>
	 * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 
	 * shiroDialect		:	(ShiroDialect，为了在thymeleaf里使用shiro的标签的bean). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}

	/**
	 * 
	 * shirFilter		:	(处理拦截资源文件问题). <br/>
	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager.<br/>
	 * 
	 * Filter Chain定义说明.<br/>
	 * 1、一个URL可以配置多个Filter，使用逗号分隔.<br/>
	 * 2、当设置多个过滤器时，全部验证通过，才视为通过.<br/>
	 * 3、部分过滤器可指定参数，如perms，roles.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param securityManager
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();

		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/api/get/home/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/api/get/home/wellcome");
		//未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/api/get/home/403");
		//拦截器.
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/api/post/home/login","anon");
		filterChainDefinitionMap.put("/api/get/home/403","anon");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/css/**","anon");
		filterChainDefinitionMap.put("/js/**","anon");
		filterChainDefinitionMap.put("/img/**","anon");
		filterChainDefinitionMap.put("/font-awesome/**","anon");
		//<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		//自定义加载权限资源关系
		List<SysResources> resourcesList = systemResourcesService.queryAll();
		for(SysResources resources : resourcesList){

			if (StringUtil.isNotEmpty(resources.getResurl())) {
				String permission = "perms[" + resources.getResurl()+ "]";
				filterChainDefinitionMap.put(resources.getResurl(),permission);
			}
		}
		filterChainDefinitionMap.put("/**", "authc");


		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}


	/**
	 * 
	 * securityManager		:	(权限管理). <br/>
	 * 权限管理，这个类组合了登陆，登出，权限，session的处理，是个比较重要的类。.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		//设置realm.
		securityManager.setRealm(myShiroRealm());
		// 自定义缓存实现 使用redis
		securityManager.setCacheManager(cacheManager());
		// 自定义session管理 使用redis
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	/**
	 * 
	 * myShiroRealm		:	(自定义的认证类). <br/>
	 * 自定义的认证类，继承自AuthorizingRealm，负责用户的认证和权限的处理，可以参考JdbcRealm的实现。.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}

	/**
	 * 
	 * hashedCredentialsMatcher		:	(凭证匹配器). <br/>
	 * 这个类是为了对密码进行编码的，防止密码在数据库里明码保存，当然在登陆认证的时候，这个类也负责对form里输入的密码进行编码。.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));

		return hashedCredentialsMatcher;
	}

	/**
	 * 
	 * authorizationAttributeSourceAdvisor		:	(开启shiro aop注解支持.). <br/>
	 * shiro里实现的Advisor类，内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法。.<br/>
	 * 使用代理方式;所以需要开启代码支持;.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param securityManager
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * 
	 * redisManager		:	(配置shiro redisManager). <br/>
	 * 使用的是shiro-redis开源插件.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost(host);
		redisManager.setPort(port);
		redisManager.setExpire(1800);// 配置缓存过期时间
		redisManager.setTimeout(timeout);
		// redisManager.setPassword(password);
		return redisManager;
	}

	/**
	 * 
	 * cacheManager		:	(缓存 redis实现). <br/>
	 * 使用的是shiro-redis开源插件.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager());
		return redisCacheManager;
	}

	/**
	 * 
	 * redisSessionDAO		:	(shiro sessionDao层的实现 通过redis). <br/>
	 * 使用的是shiro-redis开源插件.<br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		redisSessionDAO.setRedisManager(redisManager());
		return redisSessionDAO;
	}

	/**
	 * 
	 * sessionManager		:	(session的管理). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionDAO(redisSessionDAO());
		return sessionManager;
	}
}
