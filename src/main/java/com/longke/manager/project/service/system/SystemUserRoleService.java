/**
 * Project Name		:	manager-project
 * File Name		:	SystemUserRoleService.java
 * Package Name		:	com.longke.manager.project.service.system
 * Date				:	2018年2月28日下午9:40:46
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.service.system;

import com.longke.manager.project.entity.generator.SysUserRole;
import com.longke.manager.project.entity.system.MySysUserRole;
import com.longke.manager.project.service.base.BaseService;

/**
 * ClassName		:	SystemUserRoleService <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:40:46 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface SystemUserRoleService extends BaseService<SysUserRole> {
	public void addUserRole(MySysUserRole mySysUserRole);
}
