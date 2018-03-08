/**
 * Project Name		:	manager-project
 * File Name		:	BaseDTO.java
 * Package Name		:	com.longke.manager.project.dto.base
 * Date				:	2018年3月8日下午2:52:17
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.dto.base;

import java.io.Serializable;

import com.longke.manager.project.util.JsonUtil;

/**
 * ClassName		:	BaseDTO <br/>
 * Function			:	baseDTO. <br/>
 * Date				:	2018年3月8日 下午2:52:17 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class BaseDTO implements Serializable {

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
