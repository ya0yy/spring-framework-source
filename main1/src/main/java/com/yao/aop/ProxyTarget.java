package com.yao.aop;


import com.yao.aop.annotation.Y;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2020-02-15 23:32
 *
 * @author yaoyy
 */
//@Y
//@Component
public class ProxyTarget{

	@Autowired
	B b;

	private String s;
	public ProxyTarget(String s) {
		this.s = s;
	}
	public ProxyTarget(){}

	public int m1() {
		System.out.println("invoke m1");
		return 1;
	}

	public void m2() {
		System.out.println("m2: " + this.s);
	}

//	@Override
	public void i() {
		System.out.println("i 方法");
	}
}
