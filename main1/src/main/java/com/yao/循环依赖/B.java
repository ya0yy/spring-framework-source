package com.yao.循环依赖;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2020-02-12 23:28
 *
 * @author yaoyy
 */
@Component
public class B {
	@Autowired
	C c;

	public B() {
		System.out.println("B");
	}
}
