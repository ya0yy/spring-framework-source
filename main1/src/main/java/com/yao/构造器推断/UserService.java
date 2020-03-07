package com.yao.构造器推断;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

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
 * 2020-02-19 15:28
 *
 * @author yaoyy
 */
@Component
public class UserService {

//	@Autowired(required = false)
//	public UserService(OrderService orderService, ApplicationContext context, ItemService itemService) {
//		System.out.println("构造器三");
//	}

	/**
	 * 可以允许有多个@Auutowired(required = false)的构造器，但是required属性值不能为true
	 */
//	@Autowired(required = false)
	public UserService(OrderService orderService, ApplicationContext context) {
		System.out.println("构造器二");
	}

	@Autowired(required = false)
	@ConstructorProperties({"orderService"})	// beanName
	public UserService(OrderService orderService) {
		System.out.println("构造器一");
	}

	@Autowired(required = false)
	public UserService(ItemService itemService) {
		System.out.println("itemService 构造");
	}

//	@Autowired(required = false)
	public UserService() {
		System.out.println("空参构造");
	}

}
