/**
 * Project Name		:	manager-project
 * File Name		:	SystemUserServiceImpl.java
 * Package Name		:	com.longke.manager.project.service.system.impl
 * Date				:	2018年3月1日上午9:47:57
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longke.manager.project.dao.generator.SysUserRoleMapper;
import com.longke.manager.project.entity.generator.SysUser;
import com.longke.manager.project.entity.generator.SysUserRole;
import com.longke.manager.project.service.base.impl.BaseServiceImpl;
import com.longke.manager.project.service.system.SystemUserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

/**
 * ClassName		:	SystemUserServiceImpl <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午9:47:57 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class SystemUserServiceImpl extends BaseServiceImpl<SysUser> implements SystemUserService {

	@Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public PageInfo<SysUser> selectByPage(SysUser user, int start, int length) {
        int page = start/length+1;
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(user.getUsername())) {
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }
        if (user.getId() != null) {
            criteria.andEqualTo("id", user.getId());
        }
        if (user.getEnable() != null) {
            criteria.andEqualTo("enable", user.getEnable());
        }
        //分页查询
        PageHelper.startPage(page, length);
        List<SysUser> userList = selectByExample(example);
        return new PageInfo<>(userList);
    }

    @Override
    public SysUser selectByUsername(String username) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<SysUser> userList = selectByExample(example);
        if(userList.size()>0){
            return userList.get(0);
        }
            return null;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delUser(Integer userid) {
        //删除用户表
        mapper.deleteByPrimaryKey(userid);
        //删除用户角色表
        Example example = new Example(SysUserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid",userid);
        sysUserRoleMapper.deleteByExample(example);
    }
}
