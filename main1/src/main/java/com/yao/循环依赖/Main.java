package com.yao.循环依赖;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 2020-02-12 23:24
 *
 * @author yaoyy
 */
@ComponentScan("com.yao.循环依赖")
@EnableAsync
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		D d = context.getBean(D.class);
//		d.sayHello();
	}
}
