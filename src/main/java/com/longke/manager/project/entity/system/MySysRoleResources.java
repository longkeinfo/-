/**
 * Project Name		:	manager-project
 * File Name		:	MySysRoleResources.java
 * Package Name		:	com.longke.manager.project.entity.system
 * Date				:	2018年3月1日上午8:46:50
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.entity.system;

import javax.persistence.Transient;

import com.longke.manager.project.entity.generator.SysRoleResources;

/**
 * ClassName		:	MySysRoleResources <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午8:46:50 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class MySysRoleResources extends SysRoleResources {
	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
	
	@Transient
	private String resourcesids;

	public String getResourcesids() {
		return resourcesids;
	}

	public void setResourcesids(String resourcesids) {
		this.resourcesids = resourcesids;
	}
}
