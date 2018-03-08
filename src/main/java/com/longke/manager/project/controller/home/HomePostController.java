/**
 * Project Name		:	manager-project
 * File Name		:	HomePostController.java
 * Package Name		:	com.longke.manager.project.controller.home
 * Date				:	2018年3月5日下午2:52:44
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.controller.home;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.longke.manager.project.dto.param.home.SystemUserLoginParam;
import com.longke.manager.project.entity.format.DataResult;
import com.longke.manager.project.util.HttpUtil;

/**
 * ClassName		:	HomePostController <br/>
 * Function			:	基础POST请求控制器. <br/>
 * Date				:	2018年3月5日 下午2:52:44 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/api/post/home")
public class HomePostController {

	/**
	 * 
	 * login		:	(用户登陆接口). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param request
	 * @param systemUserLoginParam
	 * @return
	 * @since					:	JDK 1.8
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public DataResult login(HttpServletRequest request, SystemUserLoginParam systemUserLoginParam){
		DataResult res = new DataResult();
		
		System.out.println(systemUserLoginParam);
		
		if (this.checkParamWithLogin(systemUserLoginParam, res)) {
			System.out.println(HttpUtil.getIpAddr(request));
			
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token=new UsernamePasswordToken(systemUserLoginParam.getUsername(),systemUserLoginParam.getPassword());
			try {
				subject.login(token);
				res.success("/api/get/home/wellcome", token, null);
			}catch (LockedAccountException lae) {
				token.clear();
				res.error("用户已经被锁定不能登录，请与管理员联系！");
			} catch (AuthenticationException e) {
				token.clear();
				res.error("用户或密码不正确！");
			}
		}
		return res;
	}

	/**
	 * 
	 * checkParamWithLogin		:	(用户登录时校验参数的合法性). <br/>
	 *
	 * @author					:	Alex Hu
	 * @param systemUserLoginParam 用户登陆参数
	 * @param dataResult 返回校验对象
	 * @return true：校验通过	false：校验不通过
	 * @since					:	JDK 1.8
	 */
	private boolean checkParamWithLogin(SystemUserLoginParam systemUserLoginParam, DataResult dataResult) {
		if (systemUserLoginParam == null) {
			dataResult.error("数据传输失败！！！");
			return false;
		}

		if (StringUtils.isEmpty(systemUserLoginParam.getUsername())) {
			dataResult.error("登录名不能为空！！！");
			return false;
		}

		if (StringUtils.isEmpty(systemUserLoginParam.getPassword())) {
			dataResult.error("登陆密码不能为空！！！");
			return false;
		}

		return true;
	}
}
