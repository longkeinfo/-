/**
 * Project Name		:	manager-project
 * File Name		:	SystemResourcesService.java
 * Package Name		:	com.longke.manager.project.service.system
 * Date				:	2018年2月28日下午9:37:36
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.service.system;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.longke.manager.project.entity.generator.SysResources;
import com.longke.manager.project.entity.system.MySysResources;
import com.longke.manager.project.service.base.BaseService;

/**
 * ClassName		:	SystemResourcesService <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:37:36 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface SystemResourcesService extends BaseService<SysResources> {
	PageInfo<SysResources> selectByPage(SysResources sysResources, int start, int length);

	public List<SysResources> queryAll();

	public List<SysResources> loadUserResources(Map<String,Object> map);

	public List<MySysResources> queryResourcesListWithSelected(Integer rid);
}
