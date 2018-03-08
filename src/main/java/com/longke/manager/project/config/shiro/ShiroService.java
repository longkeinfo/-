/**
 * Project Name		:	manager-project
 * File Name		:	ShiroService.java
 * Package Name		:	com.longke.manager.project.config.shiro
 * Date				:	2018年3月1日上午9:53:10
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.config.shiro;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longke.manager.project.entity.generator.SysResources;
import com.longke.manager.project.service.system.SystemResourcesService;

import tk.mybatis.mapper.util.StringUtil;

/**
 * ClassName		:	ShiroService <br/>
 * Function			:	Shiro 服务接口. <br/>
 * Reason			:	权限初始化以及更新权限. <br/>
 * Date				:	2018年3月1日 上午9:53:10 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class ShiroService {
	/**
	 * 自动注入Shiro过滤工程
	 */
	@Autowired
	private ShiroFilterFactoryBean shiroFilterFactoryBean;
	
	/**
	 * 自动注入系统资源服务接口
	 */
	@Autowired
	private SystemResourcesService systemResourcesService;
	
	/**
	 * 
	 * loadFilterChainDefinitions		:	(初始化权限). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return					:	权限信息
	 * @since					:	JDK 1.8
	 */
	public Map<String, String> loadFilterChainDefinitions() {
		// 权限控制map.从数据库获取
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/css/**","anon");
		filterChainDefinitionMap.put("/js/**","anon");
		filterChainDefinitionMap.put("/img/**","anon");
		filterChainDefinitionMap.put("/font-awesome/**","anon");
		List<SysResources> resourcesList = systemResourcesService.queryAll();
		for(SysResources resources:resourcesList){

			if (StringUtil.isNotEmpty(resources.getResurl())) {
				String permission = "perms[" + resources.getResurl()+ "]";
				filterChainDefinitionMap.put(resources.getResurl(),permission);
			}
		}
		filterChainDefinitionMap.put("/**", "authc");
		return filterChainDefinitionMap;
	}

	/**
	 * 
	 * updatePermission		:	(重新加载权限). <br/>
	 *
	 * @author					:	Alex Hu
	 * @since					:	JDK 1.8
	 */
	public void updatePermission() {

		synchronized (shiroFilterFactoryBean) {

			AbstractShiroFilter shiroFilter = null;
			try {
				shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean
						.getObject();
			} catch (Exception e) {
				throw new RuntimeException(
						"get ShiroFilter from shiroFilterFactoryBean error!");
			}

			PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
					.getFilterChainResolver();
			DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver
					.getFilterChainManager();

			// 清空老的权限控制
			manager.getFilterChains().clear();

			shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
			shiroFilterFactoryBean
			.setFilterChainDefinitionMap(loadFilterChainDefinitions());
			// 重新构建生成
			Map<String, String> chains = shiroFilterFactoryBean
					.getFilterChainDefinitionMap();
			for (Map.Entry<String, String> entry : chains.entrySet()) {
				String url = entry.getKey();
				String chainDefinition = entry.getValue().trim()
						.replace(" ", "");
				manager.createChain(url, chainDefinition);
			}

			System.out.println("更新权限成功！！");
		}
	}
}
