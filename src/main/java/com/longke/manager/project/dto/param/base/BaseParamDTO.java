/**
 * Project Name		:	manager-project
 * File Name		:	BaseParamDTO.java
 * Package Name		:	com.longke.manager.project.dto.param.base
 * Date				:	2018年3月8日下午2:53:54
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.dto.param.base;

import com.longke.manager.project.dto.base.BaseDTO;

/**
 * ClassName		:	BaseParamDTO <br/>
 * Function			:	BaseParamDTO. <br/>
 * Date				:	2018年3月8日 下午2:53:54 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class BaseParamDTO extends BaseDTO {

	/** 
	 * serialVersionUID			:	.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ip地址
	 */
	private String ipAddr;

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
}
