package com.yao.cglib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 2020-02-11 22:45
 *
 * @author yaoyy
 */
// 当此类被@Configuration并且proxyBeanMethod属性为true，此类生成的bean是被cglib代理的类，并且类中@Bean的方法不能是private or final的
@Configuration(proxyBeanMethods = true)
@ComponentScan("com.yao.cglib")
public class App {

	@Bean
	public Customer customer() {
		return new Customer();
	}

	@Bean
	public CItem cItem() {
		customer();
		return new CItem();
	}
}
