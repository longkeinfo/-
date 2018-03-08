/**
 * Project Name		:	manager-project
 * File Name		:	SystemResourcesServiceImpl.java
 * Package Name		:	com.longke.manager.project.service.system.impl
 * Date				:	2018年2月28日下午9:46:36
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.service.system.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.longke.manager.project.dao.generator.SysResourcesMapper;
import com.longke.manager.project.dao.system.MySysResourcesMapper;
import com.longke.manager.project.entity.generator.SysResources;
import com.longke.manager.project.entity.system.MySysResources;
import com.longke.manager.project.service.base.impl.BaseServiceImpl;
import com.longke.manager.project.service.system.SystemResourcesService;

import tk.mybatis.mapper.entity.Example;

/**
 * ClassName		:	SystemResourcesServiceImpl <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:46:36 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service("systemResourcesService")
public class SystemResourcesServiceImpl extends BaseServiceImpl<SysResources> implements SystemResourcesService {

	@Resource
	private SysResourcesMapper sysResourcesMapper;

	@Resource
	private MySysResourcesMapper mySysResourcesMapper;

	@Override
	public PageInfo<SysResources> selectByPage(SysResources sysResources, int start, int length) {
		int page = start/length+1;
		Example example = new Example(SysResources.class);
		//分页查询
		PageHelper.startPage(page, length);
		List<SysResources> userList = selectByExample(example);
		return new PageInfo<>(userList);
	}

	@Override
	public List<SysResources> queryAll(){
		return mySysResourcesMapper.queryAll();
	}

	@Override
	//@Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
	public List<SysResources> loadUserResources(Map<String, Object> map) {
		return mySysResourcesMapper.loadUserResources(map);
	}

	@Override
	public List<MySysResources> queryResourcesListWithSelected(Integer rid) {
		return mySysResourcesMapper.queryResourcesListWithSelected(rid);
	}
}
