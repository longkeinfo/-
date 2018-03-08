/**
 * Project Name		:	manager-project
 * File Name		:	MySysRoleMapper.java
 * Package Name		:	com.longke.manager.project.dao.system
 * Date				:	2018年2月28日下午9:55:55
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.dao.system;

import java.util.List;

import com.longke.manager.project.entity.system.MySysRole;

/**
 * ClassName		:	MySysRoleMapper <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:55:55 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface MySysRoleMapper {
	public List<MySysRole> queryRoleListWithSelected(Integer id);
}
