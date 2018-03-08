/**
 * Project Name		:	manager-project
 * File Name		:	SystemRoleResourcesService.java
 * Package Name		:	com.longke.manager.project.service.system
 * Date				:	2018年2月28日下午9:39:03
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.service.system;

import com.longke.manager.project.entity.generator.SysRoleResources;
import com.longke.manager.project.entity.system.MySysRoleResources;
import com.longke.manager.project.service.base.BaseService;

/**
 * ClassName		:	SystemRoleResourcesService <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:39:03 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface SystemRoleResourcesService extends BaseService<SysRoleResources> {
	public void addRoleResources(MySysRoleResources mySysRoleResources);
}
