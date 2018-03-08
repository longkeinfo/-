/**
 * Project Name		:	manager-project
 * File Name		:	BaseService.java
 * Package Name		:	com.longke.manager.project.service.base
 * Date				:	2018年2月28日下午9:19:15
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.service.base;

import java.util.List;

/**
 * ClassName		:	BaseService <br/>
 * Function			:	通用接口. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:19:15 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface BaseService<T> {
	T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
