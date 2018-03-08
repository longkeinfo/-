package com.longke.manager.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * ClassName		:	ManagerProjectApplication <br/>
 * Function			:	Spring Boot启动类. <br/>
 * date				:	2018年3月5日 下午2:37:19 <br/>
 *
 * @author 			:	Alex Hu
 * @version 		:	1.0.1
 * @since 			:	JDK 1.8
 * 
 * @EnableTransactionManagement 启用事务管理
 * @MapperScan 递归扫描dao
 * 
 */
@SpringBootApplication
@EnableTransactionManagement
public class ManagerProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ManagerProjectApplication.class);
	}

	/**
	 * 
	 * main		:	(主方法，程序入口). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param args
	 * @since					:	JDK 1.8
	 */
	public static void main(String[] args) {
		SpringApplication.run(ManagerProjectApplication.class, args);
	}
}
