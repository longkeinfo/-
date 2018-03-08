package com.longke.manager.project;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * ClassName		:	ServletInitializer <br/>
 * Function			:	Servlet初始化程序. <br/>
 * date				:	2018年3月5日 下午2:41:20 <br/>
 *
 * @author 			:	Alex Hu
 * @version 		:	1.0.1
 * @since 			:	JDK 1.8
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ManagerProjectApplication.class);
	}

}
