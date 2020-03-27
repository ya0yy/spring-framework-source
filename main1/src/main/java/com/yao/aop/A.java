package com.yao.aop;

import com.yao.aop.annotation.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2020-02-18 16:45
 *
 * @author yaoyy
 */
@Y
@Component
public class A {

	@Autowired
	B b;

	public B getB() {
		return b;
	}

	public void sout() {
		System.out.println("A");
	}

	public void i() {

	}
}
