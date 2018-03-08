/**
 * Project Name		:	manager-project
 * File Name		:	SystemUserGetController.java
 * Package Name		:	com.longke.manager.project.controller.system.user
 * Date				:	2018年3月7日下午1:44:35
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.controller.system.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName		:	SystemUserGetController <br/>
 * Function			:	用户信息get请求控制器. <br/>
 * Date				:	2018年3月7日 下午1:44:35 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/api/get/system/user")
public class SystemUserGetController {
	@RequestMapping(value="/topage",method=RequestMethod.GET)
	public String usersPage(){
		return "user/users";
	}
}
