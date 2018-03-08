/**
 * Project Name		:	manager-project
 * File Name		:	MySysRole.java
 * Package Name		:	com.longke.manager.project.entity.system
 * Date				:	2018年3月1日上午11:51:08
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.entity.system;

import javax.persistence.Transient;

import com.longke.manager.project.entity.generator.SysRole;

/**
 * ClassName		:	MySysRole <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午11:51:08 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class MySysRole extends SysRole {

	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
	
	@Transient
    private Integer selected;
	
	public Integer getSelected() {
		return selected;
	}
	public void setSelected(Integer selected) {
		this.selected = selected;
	}
}
