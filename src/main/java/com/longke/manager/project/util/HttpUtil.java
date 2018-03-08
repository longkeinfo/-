/**
 * Project Name		:	manager-project
 * File Name		:	HttpUtil.java
 * Package Name		:	com.longke.manager.project.util
 * Date				:	2018年3月8日下午3:10:05
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName		:	HttpUtil <br/>
 * Function			:	http工具类. <br/>
 * Reason			:	获取IP地址. <br/>
 * Date				:	2018年3月8日 下午3:10:05 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class HttpUtil {
	
	/**
	 * 
	 * getIpAddr		:	(获取IP地址). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param request
	 * @return
	 * @since					:	JDK 1.8
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 ||"unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
