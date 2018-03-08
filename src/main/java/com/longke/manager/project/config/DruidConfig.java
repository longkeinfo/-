/**
 * Project Name		:	manager-project
 * File Name		:	DruidConfig.java
 * Package Name		:	com.longke.manager.project.config
 * Date				:	2018年3月1日上午9:50:41
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * ClassName		:	DruidConfig <br/>
 * Function			:	数据源配置. <br/>
 * Reason			:	. <br/>
 * Date				:	2018年3月1日 上午9:50:41 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Configuration
public class DruidConfig {
	/**
	 * 
	 * druidServlet		:	(Servlet注册). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public ServletRegistrationBean druidServlet() {

		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		//登录查看信息的账号密码.

		servletRegistrationBean.addInitParameter("loginUsername","admin");

		servletRegistrationBean.addInitParameter("loginPassword","123456");
		return servletRegistrationBean;
	}

	/**
	 * 
	 * filterRegistrationBean		:	(拦截注册). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
