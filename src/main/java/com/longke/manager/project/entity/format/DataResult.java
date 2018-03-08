/**
 * Project Name		:	manager-project
 * File Name		:	DataResult.java
 * Package Name		:	com.longke.manager.project.entity.format
 * Date				:	2018年3月1日下午1:24:43
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.entity.format;

import com.longke.manager.project.entity.base.BaseEntity;

/**
 * ClassName		:	DataResult <br/>
 * Function			:	DataResult. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 下午1:24:43 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class DataResult extends BaseEntity {

	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String SUCCESS_CODE = "00000";

	public static final String ERROR_CODE = "10000";

	public static final String SUCCESS_INFO = "请求成功";

	public static final String ERROR_INFO = "请求失败";

	/**
	 * 返回编码
	 */
	private String code;

	/**
	 * 返回消息
	 */
	private String msg;

	/**
	 * 返回的对象
	 */
	private Object obj;

	/**
	 * 数据签名
	 */
	private String sign;

	public DataResult(String code, String msg, Object obj) {
		super();
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}

	public DataResult() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 
	 * success:(数据操作成功). <br/>
	 * 
	 * @author Alex  
	 * @since JDK 1.7
	 */
	public void success(){
		this.code = SUCCESS_CODE;
		this.msg = SUCCESS_INFO;
	}

	/**
	 * 
	 * success:(数据操作成功-自定义返回消息). <br/>
	 * 
	 * @author Alex 
	 * @param msg 返回消息
	 * @since JDK 1.7
	 */
	public void success(String msg){
		this.code = SUCCESS_CODE;
		this.msg = msg;
	}

	/**
	 * 
	 * success:(数据操作成功-自定义返回对象). <br/>
	 * 
	 * @author Alex 
	 * @param obj 返回对象
	 * @since JDK 1.7
	 */
	public void success(Object obj,String sign){
		this.code = SUCCESS_CODE;
		this.msg = SUCCESS_INFO;
		this.sign = sign;
		this.obj = obj;
	}

	/**
	 * 
	 * success:(数据操作成功-自定义返回消息和对象). <br/>
	 * 
	 * @author Alex 
	 * @param msg 返回消息
	 * @param obj 返回对象
	 * @since JDK 1.7
	 */
	public void success(String msg,Object obj,String sign){
		this.code = SUCCESS_CODE;
		this.msg = msg;
		this.sign = sign;
		this.obj = obj;
	}

	/**
	 * 
	 * error:(数据操作失败). <br/>
	 * 
	 * @author Alex  
	 * @since JDK 1.7
	 */
	public void error(){
		this.code = ERROR_CODE;
		this.msg = ERROR_INFO;
	}

	/**
	 * 
	 * error:(数据操作失败-自定义返回消息). <br/>
	 * 
	 * @author Alex 
	 * @param msg 返回消息
	 * @since JDK 1.7
	 */
	public void error(String msg){
		this.code = ERROR_CODE;
		this.msg = msg;
	}

	/**
	 * 
	 * error:(数据操作失败-自定义返回对象). <br/>
	 * 
	 * @author Alex 
	 * @param obj 返回对象
	 * @since JDK 1.7
	 */
	public void error(Object obj,String sign){
		this.code = ERROR_CODE;
		this.msg = ERROR_INFO;
		this.sign = sign;
		this.obj = obj;
	}

	/**
	 * 
	 * error:(数据操作失败-自定义返回消息和对象). <br/>
	 * 
	 * @author Alex 
	 * @param msg 返回消息
	 * @param obj 返回对象
	 * @since JDK 1.7
	 */
	public void error(String msg,Object obj,String sign){
		this.code = ERROR_CODE;
		this.msg = msg;
		this.sign = sign;
		this.obj = obj;
	}
	
	/**
	 * 
	 * error:(数据操作失败-自定义返回消息和对象). <br/>
	 * 
	 * @author Alex 
	 * @param msg 返回消息
	 * @param obj 返回对象
	 * @since JDK 1.7
	 */
	public void error(String code,String msg,Object obj,String sign){
		this.code = code;
		this.msg = msg;
		this.sign = sign;
		this.obj = obj;
	}
}
