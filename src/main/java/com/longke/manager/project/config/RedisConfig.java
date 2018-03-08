/**
 * Project Name		:	manager-project
 * File Name		:	RedisConfig.java
 * Package Name		:	com.longke.manager.project.config
 * Date				:	2018年3月1日上午9:51:21
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.longke.manager.project.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName		:	RedisConfig <br/>
 * Function			:	redis缓存配置. <br/>
 * Reason			:	. <br/>
 * Date				:	2018年3月1日 上午9:51:21 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	/**
	 * 读取配置文件中的缓存地址
	 */
	@Value("${spring.redis.host}")
	private String host;

	/**
	 * 读取配置文件中的缓存端口
	 */
	@Value("${spring.redis.port}")
	private int port;

	/**
	 * 读取配置文件中的缓存超时时间
	 */
	@Value("${spring.redis.timeout}")
	private int timeout;

	/**
	 * 读取配置文件中的缓存最大连接池
	 */
	@Value("${spring.redis.pool.max-idle}")
	private int maxIdle;

	/**
	 * 读取配置文件中的缓存最大等待数量
	 */
	@Value("${spring.redis.pool.max-wait}")
	private long maxWaitMillis;

	/**
	 * 
	 * redisPoolFactory		:	(缓存池工厂). <br/>
	 *
	 * @author					:	Alex Hu
	 * @return					:	jedis缓存池
	 * @since					:	JDK 1.8
	 */
	@Bean
	public JedisPool redisPoolFactory() {
		Logger.getLogger(getClass()).info("JedisPool注入成功！！");
		Logger.getLogger(getClass()).info("redis地址：" + host + ":" + port);
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);

		return jedisPool;
	}
}
