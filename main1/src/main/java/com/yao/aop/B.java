package com.yao.aop;

import com.yao.aop.annotation.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2020-02-18 15:19
 *
 * @author yaoyy
 */
@Y
@Component
public class B {
	@Autowired
	A a;

	public A getA() {
		return a;
	}

	public void sout() {
		System.out.println("B");
	}
}
