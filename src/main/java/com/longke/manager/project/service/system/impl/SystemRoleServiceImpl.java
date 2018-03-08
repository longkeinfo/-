/**
 * Project Name		:	manager-project
 * File Name		:	SystemRoleServiceImpl.java
 * Package Name		:	com.longke.manager.project.service.system.impl
 * Date				:	2018年3月1日上午9:33:36
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
import com.longke.manager.project.dao.generator.SysRoleMapper;
import com.longke.manager.project.dao.generator.SysRoleResourcesMapper;
import com.longke.manager.project.dao.system.MySysRoleMapper;
import com.longke.manager.project.entity.generator.SysRole;
import com.longke.manager.project.entity.generator.SysRoleResources;
import com.longke.manager.project.entity.system.MySysRole;
import com.longke.manager.project.service.base.impl.BaseServiceImpl;
import com.longke.manager.project.service.system.SystemRoleService;

import tk.mybatis.mapper.entity.Example;

/**
 * ClassName		:	SystemRoleServiceImpl <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午9:33:36 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class SystemRoleServiceImpl extends BaseServiceImpl<SysRole> implements SystemRoleService {

	@Resource
    private SysRoleMapper sysRoleMapper;
	
	@Resource
    private MySysRoleMapper mySysRoleMapper;
	
    @Resource
    private SysRoleResourcesMapper sysRoleResourcesMapper;

    @Override
    public List<MySysRole> queryRoleListWithSelected(Integer uid) {
        return mySysRoleMapper.queryRoleListWithSelected(uid);
    }

    @Override
    public PageInfo<SysRole> selectByPage(SysRole role, int start, int length) {
        int page = start/length+1;
        Example example = new Example(SysRole.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<SysRole> rolesList = selectByExample(example);
        return new PageInfo<>(rolesList);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delRole(Integer roleid) {
        //删除角色
        mapper.deleteByPrimaryKey(roleid);
        //删除角色资源
        Example example = new Example(SysRoleResources.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",roleid);
        sysRoleResourcesMapper.deleteByExample(example);
    }
}
