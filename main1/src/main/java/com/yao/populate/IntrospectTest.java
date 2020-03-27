package com.yao.populate;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * 2020-03-02 01:38
 *
 * @author yaoyy
 */
public class IntrospectTest {

	private int a;
	private int b;
	private int c;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public static void main(String[] args) throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(IntrospectTest.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getDisplayName());
		}
	}
}
