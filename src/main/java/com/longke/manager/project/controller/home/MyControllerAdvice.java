/**
 * Project Name		:	manager-project
 * File Name		:	MyControllerAdvice.java
 * Package Name		:	com.longke.manager.project.controller.home
 * Date				:	2018年3月1日下午1:11:52
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.controller.home;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.longke.manager.project.entity.format.DataResult;

/**
 * ClassName		:	MyControllerAdvice <br/>
 * Function			:	controller 增强器. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 下午1:11:52 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@ControllerAdvice
public class MyControllerAdvice {
	/**
	 * 
	 * initBinder		:	(应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param binder
	 * @since					:	JDK 1.8
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}

	/**
	 * 
	 * addAttributes		:	(把值绑定到Model中，使全局@RequestMapping可以获取到该值). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param model
	 * @since					:	JDK 1.8
	 */
	@ModelAttribute
	public void addAttributes(Model model) {
	}

	/**
	 * 
	 * errorHandler		:	(全局异常捕捉处理). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param ex
	 * @return
	 * @since					:	JDK 1.8
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public DataResult errorHandler(Exception ex) {
		DataResult dataResult = new DataResult();
		dataResult.error("10000", ex.getMessage(), ex, null);
		return dataResult;
	}
}
