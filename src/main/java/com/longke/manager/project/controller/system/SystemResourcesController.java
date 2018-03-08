/**
 * Project Name		:	manager-project
 * File Name		:	SystemResourcesController.java
 * Package Name		:	com.longke.manager.project.controller.system
 * Date				:	2018年3月1日上午9:57:10
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.longke.manager.project.config.shiro.ShiroService;
import com.longke.manager.project.entity.generator.SysResources;
import com.longke.manager.project.entity.system.MySysResources;
import com.longke.manager.project.service.system.SystemResourcesService;

/**
 * ClassName		:	SystemResourcesController <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 上午9:57:10 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@RestController
@RequestMapping("/resources")
public class SystemResourcesController {
	@Resource
	private SystemResourcesService systemResourcesService;
	@Resource
	private ShiroService shiroService;

	@RequestMapping
	public Map<String,Object> getAll(SysResources resources, String draw,
			@RequestParam(required = false, defaultValue = "1") int start,
			@RequestParam(required = false, defaultValue = "10") int length){
		Map<String,Object> map = new HashMap<>();
		PageInfo<SysResources> pageInfo = systemResourcesService.selectByPage(resources, start, length);
		System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
		map.put("draw",draw);
		map.put("recordsTotal",pageInfo.getTotal());
		map.put("recordsFiltered",pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	@RequestMapping("/resourcesWithSelected")
	public List<MySysResources> resourcesWithSelected(Integer rid){
		return systemResourcesService.queryResourcesListWithSelected(rid);
	}

	@RequestMapping("/loadMenu")
	public List<SysResources> loadMenu(){
		Map<String,Object> map = new HashMap<>();
		Integer userid = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
		map.put("type",1);
		map.put("userid",userid);
		List<SysResources> resourcesList = systemResourcesService.loadUserResources(map);
		return resourcesList;
	}

	//@CacheEvict(cacheNames="resources", allEntries=true)
	@RequestMapping(value = "/add")
	public String add(SysResources resources){
		try{
			systemResourcesService.save(resources);
			//更新权限
			shiroService.updatePermission();
			return "success";
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	//@CacheEvict(cacheNames="resources", allEntries=true)
	@RequestMapping(value = "/delete")
	public String delete(Integer id){
		try{
			systemResourcesService.delete(id);
			//更新权限
			shiroService.updatePermission();
			return "success";
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
}
