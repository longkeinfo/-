/**
 * Project Name		:	manager-project
 * File Name		:	MySysUserRole.java
 * Package Name		:	com.longke.manager.project.entity.system
 * Date				:	2018年3月1日上午9:43:48
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.entity.system;

import javax.persistence.Transient;

import com.longke.manager.project.entity.generator.SysUserRole;

/**
 * ClassName		:	MySysUserRole <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午9:43:48 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class MySysUserRole extends SysUserRole {
	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
	
	@Transient
	private String roleids;

	public String getRoleids() {
		return roleids;
	}

	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}
}
