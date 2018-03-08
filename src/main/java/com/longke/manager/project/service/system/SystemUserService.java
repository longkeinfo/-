/**
 * Project Name		:	manager-project
 * File Name		:	SystemUserService.java
 * Package Name		:	com.longke.manager.project.service.system
 * Date				:	2018年2月28日下午9:41:19
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.service.system;

import com.github.pagehelper.PageInfo;
import com.longke.manager.project.entity.generator.SysUser;
import com.longke.manager.project.service.base.BaseService;

/**
 * ClassName		:	SystemUserService <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:41:19 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface SystemUserService extends BaseService<SysUser> {
	PageInfo<SysUser> selectByPage(SysUser sysUser, int start, int length);

	SysUser selectByUsername(String username);

	void delUser(Integer userid);
}
