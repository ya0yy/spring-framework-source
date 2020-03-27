package com.yao.构造器推断;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * 2020-02-19 15:50
 *
 * @author yaoyy
 */
@Component
public class ItemService {

	@Lookup("orderService")
	public OrderService orderService() {return null;};
	public ItemService() {
		System.out.println(orderService());
		System.out.println("我是ItemService的无参构造器");
	}

}
