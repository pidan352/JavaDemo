package com.lyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能：MybatisPlus配置类
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/2 0002
 */

@Configuration
public class MybatisPlusConfig {

	@Bean
	public SqlInjector sqlInjector() {
		return new SqlInjector();
	}
}
