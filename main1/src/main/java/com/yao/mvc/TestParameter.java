package com.yao.mvc;

import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.MethodParameter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 2020-02-23 15:08
 *
 * @author yaoyy
 */
public class TestParameter {

	public static void main(String[] args) throws NoSuchMethodException {
		Method method = TestParameter.class.getDeclaredMethod("test", String.class, Integer.class);

		for (int i = 0; i < method.getParameters().length; i++) {
			MethodParameter nameParameter = new MethodParameter(method, i);
			nameParameter.initParameterNameDiscovery(new DefaultParameterNameDiscoverer());
			System.out.println(nameParameter.getParameterName());
		}
	}

	public void test(String name, Integer age) {
	}
}
