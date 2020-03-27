package com.yao.构造器推断;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 2020-02-19 15:26
 *
 * @author yaoyy
 */
@Configuration
@ComponentScan("com.yao.构造器推断")
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
//		UserService userService = context.getBean(UserService.class);
		System.out.println(context.getBean(ItemService.class).orderService());

	}

	// @Bean会用工厂方法创建，不用执行构造器推断。@Bean优先级高于被扫描到的（beanName相同的话）
//	@Bean
	ItemService itemService() {
		return new ItemService();
	}
}
