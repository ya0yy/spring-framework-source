package com.yao.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 2020-02-06 23:47
 *
 * @author yaoyy
 */

@Primary
@Component
public class Impl2 implements Type {
	@Override
	public void sayHello() {
		System.out.println("i am impl 2");
	}
}
