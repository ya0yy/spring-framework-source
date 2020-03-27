package com.yao.cglib.demo;

import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.proxy.Enhancer;

/**
 * 2020-02-11 23:49
 *
 * 如果要创建class要先设置callbackType
 *
 * @author yaoyy
 */
public class CGLibDemo {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TargetObject.class);

//		enhancer.setCallbackType(TargetInterceptor.class);
//		Class aClass = enhancer.createClass();
//		Object o = aClass.newInstance();

		enhancer.setCallback(new TargetInterceptor());
		TargetObject targetObject2=(TargetObject)enhancer.create();

		System.out.println(targetObject2);
		System.out.println(targetObject2.method1("mmm1"));
		System.out.println(targetObject2.method2(100));
		System.out.println(targetObject2.method3(200));
	}
}
