/**
 * Project Name		:	pingan-health-insurance
 * File Name		:	MyMapper.java
 * Package Name		:	com.pingan.health.insurance.util
 * Date				:	2018年2月28日上午11:46:01
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * ClassName		:	MyMapper <br/>
 * Function			:	通用mapper接口程序. <br/>
 * Date				:	2018年2月28日 上午11:46:01 <br/>
 * Desc				:
 * 	特别注意，该接口不能被扫描到，否则会出错
 * 
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
