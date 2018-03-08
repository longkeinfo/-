/**
 * Project Name		:	manager-project
 * File Name		:	SystemDataSourceConfig.java
 * Package Name		:	com.longke.manager.project.config.datasource
 * Date				:	2018年3月7日上午11:53:31
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.config.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName		:	SystemDataSourceConfig <br/>
 * Function			:	系统数据库配置. <br/>
 * Date				:	2018年3月7日 上午11:53:31 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Configuration  
//扫描 Mapper 接口并容器管理  
@MapperScan(basePackages = SystemDataSourceConfig.PACKAGE)
public class SystemDataSourceConfig {
	// 精确到 master 目录，以便跟其他数据源隔离  
	static final String PACKAGE = "com.longke.manager.project.dao";  
}
