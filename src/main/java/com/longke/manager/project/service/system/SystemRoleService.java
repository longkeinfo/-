/**
 * Project Name		:	manager-project
 * File Name		:	SystemRoleService.java
 * Package Name		:	com.longke.manager.project.service.system
 * Date				:	2018年2月28日下午9:40:13
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.service.system;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.longke.manager.project.entity.generator.SysRole;
import com.longke.manager.project.entity.system.MySysRole;
import com.longke.manager.project.service.base.BaseService;

/**
 * ClassName		:	SystemRoleService <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:40:13 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface SystemRoleService extends BaseService<SysRole> {
	public List<MySysRole> queryRoleListWithSelected(Integer uid);

	PageInfo<SysRole> selectByPage(SysRole sysRole, int start, int length);

	/**
	 * 删除角色 同时删除角色资源表中的数据
	 * @param roleid
	 */
	public void delRole(Integer roleid);
}
