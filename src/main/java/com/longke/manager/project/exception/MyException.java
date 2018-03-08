/**
 * Project Name		:	manager-project
 * File Name		:	MyException.java
 * Package Name		:	com.longke.manager.project.exception
 * Date				:	2018年3月1日下午1:56:06
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.exception;
/**
 * ClassName		:	MyException <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年3月1日 下午1:56:06 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public class MyException extends Exception {

	/** 
	 * serialVersionUID			:	TODO(用一句话描述这个变量表示什么).
	 * @since			:	JDK 1.8
	 */
	private static final long serialVersionUID = 1L;
	
	public MyException(){
        super();
    }

    public MyException(Exception ex){
        super(ex);
    }

    public MyException(String message){
        super(message);
    }

}
