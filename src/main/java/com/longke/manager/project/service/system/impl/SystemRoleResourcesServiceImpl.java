/**
 * Project Name		:	manager-project
 * File Name		:	SystemRoleResourcesServiceImpl.java
 * Package Name		:	com.longke.manager.project.service.system.impl
 * Date				:	2018年3月1日上午8:39:41
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.longke.manager.project.config.shiro.MyShiroRealm;
import com.longke.manager.project.dao.generator.SysUserRoleMapper;
import com.longke.manager.project.dao.system.MySysUserRoleMapper;
import com.longke.manager.project.entity.generator.SysRoleResources;
import com.longke.manager.project.entity.system.MySysRoleResources;
import com.longke.manager.project.service.base.impl.BaseServiceImpl;
import com.longke.manager.project.service.system.SystemRoleResourcesService;

import tk.mybatis.mapper.entity.Example;

/**
 * ClassName		:	SystemRoleResourcesServiceImpl <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午8:39:41 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class SystemRoleResourcesServiceImpl extends BaseServiceImpl<SysRoleResources> implements SystemRoleResourcesService {

	@Resource
    private SysUserRoleMapper sysUserRoleMapper;
	
	@Resource
    private MySysUserRoleMapper mySysUserRoleMapper;
    /*@Resource
    private ShiroService shiroService;*/
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    //更新权限
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    //@CacheEvict(cacheNames="resources", allEntries=true)
    public void addRoleResources(MySysRoleResources mySysRoleResources) {
        //删除
        Example example = new Example(SysRoleResources.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",mySysRoleResources.getRoleid());
        mapper.deleteByExample(example);
        //添加
        if(!StringUtils.isEmpty(mySysRoleResources.getResourcesids())){
            String[] resourcesArr = mySysRoleResources.getResourcesids().split(",");
            for(String resourcesId:resourcesArr ){
            	SysRoleResources r = new SysRoleResources();
                r.setRoleid(mySysRoleResources.getRoleid());
                r.setResourcesid(Integer.valueOf(resourcesId));
                mapper.insert(r);
            }
        }

        List<Integer> userIds = mySysUserRoleMapper.findUserIdByRoleId(mySysRoleResources.getRoleid());
        //更新当前登录的用户的权限缓存
        myShiroRealm.clearUserAuthByUserId(userIds);
    }

}
