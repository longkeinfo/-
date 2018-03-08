/**
 * Project Name		:	manager-project
 * File Name		:	MySysUserRoleMapper.java
 * Package Name		:	com.longke.manager.project.dao.system
 * Date				:	2018年2月28日下午9:57:40
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.dao.system;

import java.util.List;

/**
 * ClassName		:	MySysUserRoleMapper <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:57:40 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface MySysUserRoleMapper {
	public List<Integer> findUserIdByRoleId(Integer roleId);
}
