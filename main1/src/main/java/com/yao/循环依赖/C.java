package com.yao.循环依赖;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 2020-02-12 23:29
 *
 * @author yaoyy
 */
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class C {
	@Autowired
	A a;

	public C() {
		System.out.println("C");
	}
}
