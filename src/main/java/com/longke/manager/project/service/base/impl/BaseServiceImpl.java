/**
 * Project Name		:	manager-project
 * File Name		:	BaseServiceImpl.java
 * Package Name		:	com.longke.manager.project.service.base.impl
 * Date				:	2018年2月28日下午9:22:35
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.longke.manager.project.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.longke.manager.project.service.base.BaseService;

import tk.mybatis.mapper.common.Mapper;

/**
 * ClassName		:	BaseServiceImpl <br/>
 * Function			:	通用接口. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年2月28日 下午9:22:35 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
}
