package com.yao.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 2020-03-09 23:27
 *
 * @author yaoyy
 */
@ComponentScan("com.yao.lazy")
@Configuration
public class AppConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@Bean
	public NormalBean normalBean(LazyBean lazyBean) {
		System.out.println(lazyBean);
		return new NormalBean();
	}
}
