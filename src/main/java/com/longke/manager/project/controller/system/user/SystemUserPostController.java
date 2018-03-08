/**
 * Project Name		:	manager-project
 * File Name		:	SystemUserPostController.java
 * Package Name		:	com.longke.manager.project.controller.system.user
 * Date				:	2018年3月7日下午6:17:42
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.controller.system.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.longke.manager.project.entity.format.DataResult;
import com.longke.manager.project.entity.format.DataTable;
import com.longke.manager.project.entity.generator.SysUser;
import com.longke.manager.project.service.system.SystemUserRoleService;
import com.longke.manager.project.service.system.SystemUserService;

/**
 * ClassName		:	SystemUserPostController <br/>
 * Function			:	用户信息post请求控制器. <br/>
 * Date				:	2018年3月7日 下午6:17:42 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/api/post/system/user")
public class SystemUserPostController {
	@Resource
	private SystemUserService systemUserService;
	@Resource
	private SystemUserRoleService systemUserRoleService;

	@RequestMapping
	@ResponseBody
	public DataResult getAll(SysUser sysUser, String draw, @RequestParam(required = false, defaultValue = "1") int start, @RequestParam(required = false, defaultValue = "10") int length){
		DataResult res = new DataResult();
		
		DataTable<SysUser> dataTable = new DataTable<>();
		Map<String,Object> map = new HashMap<>();
		PageInfo<SysUser> pageInfo = systemUserService.selectByPage(sysUser, start, length);
		System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return res;
	}
}
