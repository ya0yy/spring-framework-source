package com.yao.factorymethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigInteger;

/**
 * 2021-01-05 16:55
 *
 * @author yaoyy
 */
@ComponentScan(basePackageClasses = FactoryMethodTest.class)
public class FactoryMethodTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(FactoryMethodTest.class);
	}

	@Bean()
	public BEAN t () {
		return new BEAN();
	}
	@Bean
	public BEAN t (String str) {
		return new BEAN();
	}

	static class BEAN {
		int i = 999;
	}
}
