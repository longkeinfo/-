/**
 * Project Name		:	manager-project
 * File Name		:	SystemUserRoleServiceImpl.java
 * Package Name		:	com.longke.manager.project.service.system.impl
 * Date				:	2018年3月1日上午9:41:27
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.longke.manager.project.config.shiro.MyShiroRealm;
import com.longke.manager.project.entity.generator.SysUserRole;
import com.longke.manager.project.entity.system.MySysUserRole;
import com.longke.manager.project.service.base.impl.BaseServiceImpl;
import com.longke.manager.project.service.system.SystemUserRoleService;

import tk.mybatis.mapper.entity.Example;

/**
 * ClassName		:	SystemUserRoleServiceImpl <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午9:41:27 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class SystemUserRoleServiceImpl extends BaseServiceImpl<SysUserRole> implements SystemUserRoleService {
	@Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addUserRole(MySysUserRole mySysUserRole) {
        //删除
        Example example = new Example(SysUserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid",mySysUserRole.getUserid());
        mapper.deleteByExample(example);
        //添加
        String[] roleids = mySysUserRole.getRoleids().split(",");
        for (String roleId : roleids) {
        	SysUserRole u = new SysUserRole();
            u.setUserid(mySysUserRole.getUserid());
            u.setRoleid(Integer.valueOf(roleId));
            mapper.insert(u);
        }
        //更新当前登录的用户的权限缓存
        List<Integer> userid = new ArrayList<Integer>();
        userid.add(mySysUserRole.getUserid());
        myShiroRealm.clearUserAuthByUserId(userid);
    }
}
