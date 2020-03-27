package com.yao.循环依赖;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 2020-02-12 23:28
 *
 * @author yaoyy
 */
@Component
public class A {

	String s;

	@Value("#{'123'}")
	public void setS(String s) {
		this.s = s;
	}

	@Autowired
	B b;

	public A() {
		System.out.println("A");
	}
}
