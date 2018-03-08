/**
 * Project Name		:	manager-project
 * File Name		:	HomeGetController.java
 * Package Name		:	com.longke.manager.project.controller.home
 * Date				:	2018年3月5日下午2:50:09
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName		:	HomeGetController <br/>
 * Function			:	基础get请求控制器. <br/>
 * Date				:	2018年3月5日 下午2:50:09 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/api/get/home")
public class HomeGetController {
	/**
	 * 
	 * login		:	(跳转登录界面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@RequestMapping(value="/login",method= RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	/**
	 * 
	 * wellcome		:	(跳转欢迎界面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@RequestMapping(value="/wellcome",method= RequestMethod.GET)
	public String wellcome(){
		return "wellcome";
	}

	/**
	 * 
	 * forbidden		:	(跳转403错误页面). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return
	 * @since					:	JDK 1.8
	 */
	@RequestMapping("/403")
	public String forbidden(){
		return "403";
	}
}
