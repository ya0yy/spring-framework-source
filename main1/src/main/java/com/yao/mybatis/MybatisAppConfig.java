package com.yao.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 2020-03-16 22:58
 *
 * @author yaoyy
 */
@MapperScan("com.yao.mybatis.mapper")
@ComponentScan("com.yao.mybatis")
@Configuration
public class MybatisAppConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MybatisAppConfig.class);
	}
}
