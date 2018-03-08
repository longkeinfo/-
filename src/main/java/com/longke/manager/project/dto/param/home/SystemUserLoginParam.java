/**
 * Project Name		:	manager-project
 * File Name		:	SystemUserLoginParam.java
 * Package Name		:	com.longke.manager.project.dto.param.home
 * Date				:	2018年3月8日下午2:55:02
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.dto.param.home;

import com.longke.manager.project.dto.param.base.BaseParamDTO;

/**
 * ClassName		:	SystemUserLoginParam <br/>
 * Function			:	系统用户登陆参数信息. <br/>
 * Date				:	2018年3月8日 下午2:55:02 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class SystemUserLoginParam extends BaseParamDTO {

	/** 
	 * serialVersionUID			:	.
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
