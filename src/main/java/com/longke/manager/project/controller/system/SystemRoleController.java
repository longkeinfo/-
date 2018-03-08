/**
 * Project Name		:	manager-project
 * File Name		:	SystemRoleController.java
 * Package Name		:	com.longke.manager.project.controller.system
 * Date				:	2018年3月1日上午10:00:23
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.longke.manager.project.entity.generator.SysRole;
import com.longke.manager.project.entity.system.MySysRole;
import com.longke.manager.project.entity.system.MySysRoleResources;
import com.longke.manager.project.service.system.SystemRoleResourcesService;
import com.longke.manager.project.service.system.SystemRoleService;

/**
 * ClassName		:	SystemRoleController <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午10:00:23 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@RestController
@RequestMapping("/roles")
public class SystemRoleController {
	@Resource
	private SystemRoleService systemRoleService;
	@Resource
	private SystemRoleResourcesService systemRoleResourcesService;

	@RequestMapping
	public  Map<String,Object> getAll(SysRole role, String draw,
			@RequestParam(required = false, defaultValue = "1") int start,
			@RequestParam(required = false, defaultValue = "10") int length){

		Map<String,Object> map = new HashMap<>();
		PageInfo<SysRole> pageInfo = systemRoleService.selectByPage(role, start, length);
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	@RequestMapping("/rolesWithSelected")
	public List<MySysRole> rolesWithSelected(Integer uid){
		return systemRoleService.queryRoleListWithSelected(uid);
	}

	//分配角色
	@RequestMapping("/saveRoleResources")
	public String saveRoleResources(MySysRoleResources mySysRoleResources){
		if(StringUtils.isEmpty(mySysRoleResources.getRoleid()))
			return "error";
		try {
			systemRoleResourcesService.addRoleResources(mySysRoleResources);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping(value = "/add")
	public String add(SysRole role) {
		try {
			systemRoleService.save(role);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping(value = "/delete")
	public String delete(Integer id){
		try{
			systemRoleService.delRole(id);
			return "success";
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
}
