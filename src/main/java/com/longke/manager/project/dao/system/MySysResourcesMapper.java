/**
 * Project Name		:	manager-project
 * File Name		:	MySysResourcesMapper.java
 * Package Name		:	com.longke.manager.project.dao.system
 * Date				:	2018年2月28日下午9:54:08
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.dao.system;

import java.util.List;
import java.util.Map;

import com.longke.manager.project.entity.generator.SysResources;
import com.longke.manager.project.entity.system.MySysResources;

/**
 * ClassName		:	MySysResourcesMapper <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:54:08 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface MySysResourcesMapper {
	public List<SysResources> queryAll();

	public List<SysResources> loadUserResources(Map<String,Object> map);

	public List<MySysResources> queryResourcesListWithSelected(Integer rid);
}
