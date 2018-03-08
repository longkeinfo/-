/**
 * Project Name		:	manager-project
 * File Name		:	SystemUserController.java
 * Package Name		:	com.longke.manager.project.controller.system
 * Date				:	2018年3月1日上午10:04:25
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.controller.system;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.longke.manager.project.entity.generator.SysUser;
import com.longke.manager.project.entity.system.MySysUserRole;
import com.longke.manager.project.service.system.SystemUserRoleService;
import com.longke.manager.project.service.system.SystemUserService;
import com.longke.manager.project.util.PasswordHelper;

/**
 * ClassName		:	SystemUserController <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午10:04:25 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@RestController
@RequestMapping("/")
public class SystemUserController {
	@Resource
	private SystemUserService systemUserService;
	@Resource
	private SystemUserRoleService systemUserRoleService;

	@RequestMapping
	public Map<String,Object> getAll(SysUser sysUser, String draw,
			@RequestParam(required = false, defaultValue = "1") int start,
			@RequestParam(required = false, defaultValue = "10") int length){
		Map<String,Object> map = new HashMap<>();
		PageInfo<SysUser> pageInfo = systemUserService.selectByPage(sysUser, start, length);
		System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}


	/**
	 * 保存用户角色
	 * @param userRole 用户角色
	 *  	  此处获取的参数的角色id是以 “,” 分隔的字符串
	 * @return
	 */
	@RequestMapping("/saveUserRoles")
	public String saveUserRoles(MySysUserRole mySysUserRole){
		if(StringUtils.isEmpty(mySysUserRole.getUserid()))
			return "error";
		try {
			systemUserRoleService.addUserRole(mySysUserRole);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping(value = "/add")
	public String add(SysUser sysUser) {
		SysUser u = systemUserService.selectByUsername(sysUser.getUsername());
		if(u != null)
			return "error";
		try {
			sysUser.setEnable(1);
			PasswordHelper passwordHelper = new PasswordHelper();
			passwordHelper.encryptPassword(sysUser);
			systemUserService.save(sysUser);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping(value = "/delete")
	public String delete(Integer id){
		try{
			systemUserService.delUser(id);
			return "success";
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}
	}

}

