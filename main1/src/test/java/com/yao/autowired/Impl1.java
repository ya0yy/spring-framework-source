package com.yao.autowired;

import org.springframework.stereotype.Component;

/**
 * 2020-02-06 23:47
 *
 * @author yaoyy
 */
@Component
public class Impl1 implements Type {
	@Override
	public void sayHello() {
		System.out.println("i am impl 1");
	}
}
