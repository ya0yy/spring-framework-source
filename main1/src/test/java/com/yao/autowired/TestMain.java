package com.yao.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2020-02-06 23:48
 *
 * 注解@autowired先通过类型找，再通过名称找
 *
 * @author yaoyy
 */
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.yao.autowired");
		TestService bean = ac.getBean(TestService.class);
		bean.say();
	}
}
