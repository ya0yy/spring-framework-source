package com.yao.cglib.demo;

/**
 * 没有实现接口，需要CGlib动态代理的目标类
 *
 * @author zghw
 *
 */
public class TargetObject {
	public String method1(String paramName) {
		return paramName;
	}

	public int method2(int count) {
		System.out.println("method2");
		return count;
	}

	public int method3(int count) {
		this.method2(count);
		System.out.println("method3");
		return count;
	}

	@Override
	public String toString() {
		return "TargetObject []"+ getClass();
	}
}