package com.yao.bean的初始化方法;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 2020-03-02 14:32
 *
 * @author yaoyy
 */
@ComponentScan("com.yao.bean的初始化方法")
@Configuration
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
	}

	@Bean
	public TestMethodBean testMethodBean() {
		return new TestMethodBean();
	}
}
