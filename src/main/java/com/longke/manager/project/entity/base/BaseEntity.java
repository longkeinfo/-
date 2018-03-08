/**
 * Project Name		:	manager-project
 * File Name		:	BaseEntity.java
 * Package Name		:	com.longke.manager.project.entity.base
 * Date				:	2018年2月28日下午9:17:05
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.entity.base;

import java.io.Serializable;

import com.longke.manager.project.util.JsonUtil;

/**
 * ClassName		:	BaseEntity <br/>
 * Function			:	基础实体类. <br/>
 * Date				:	2018年2月28日 下午9:17:05 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class BaseEntity implements Serializable {
	/** 
	 * serialVersionUID			:	.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}
}
