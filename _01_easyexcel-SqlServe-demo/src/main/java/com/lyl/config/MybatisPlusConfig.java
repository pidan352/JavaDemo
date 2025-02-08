package com.lyl.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
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
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor();
		//mybatisplus会根据驱动来选择
		//innerInterceptor.setDbType(DbType.SQL_SERVER2005);
		////溢出总页数后是否进行处理(默认不处理
		//innerInterceptor.setOverflow(true);
		interceptor.addInnerInterceptor(innerInterceptor);
		return interceptor;
	}

	@Bean
	public SqlInjector sqlInjector() {
		return new SqlInjector();
	}
}
