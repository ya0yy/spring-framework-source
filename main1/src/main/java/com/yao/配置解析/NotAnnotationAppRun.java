package com.yao.配置解析;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2020-03-09 16:48
 *
 * @author yaoyy
 */
public class NotAnnotationAppRun {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(NotAnnotationAppRun.class);
	}
}
