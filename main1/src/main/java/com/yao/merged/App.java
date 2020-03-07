package com.yao.merged;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 　　　　　　　 ┏┓　 ┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　┃
 * 　　　　　　　┃　　　━　　 ┃ ++ + + +
 * 　　　　　　 ████━████  ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　 ┃　　　┃
 * 　　　　　　　　 ┃　　　┃ + + + +
 * 　　　　　　　　 ┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　 ┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　 ┃　　　┃
 * 　　　　　　　　 ┃　　　┃　　+
 * 　　　　　　　　 ┃　 　 ┗━━━┓ + +
 * 　　　　　　　　 ┃ 　　　　   ┣┓
 * 　　　　　　　　 ┃ 　　　　　 ┏┛
 * 　　　　　　　　 ┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　  ┃┫┫ ┃┫┫
 * 　　　　　　　　  ┗┻┛ ┗┻┛+ + + +
 * <p>
 * spring
 * 2020-02-22 23:06
 *
 * @author yaoyy
 */
@Configuration
@ComponentScan("com.yao.merged")
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		GenericBeanDefinition p = new GenericBeanDefinition();
		p.setBeanClass(ParentBean.class);
		p.getPropertyValues().add("name", "父").add("score", "99.09");

		GenericBeanDefinition c = new GenericBeanDefinition();
		c.setBeanClass(ChildBean.class);
		c.setParentName("parent");

		context.registerBeanDefinition("parent", p);
		context.registerBeanDefinition("child", c);

		context.register(App.class);

		context.refresh();

		System.out.println(context.getBean("a"));
	}

	// 如果有两个工厂方法，不会报错，只会执行第一个
	@Bean("a")
	public A a() {
		System.out.println("a");
		return new A();
	}
	@Bean("a")
	public A a1() {
		System.out.println("a1");
		return new A();
	}
}
