package com.yao.aop;

import com.yao.aop.annotation.Y;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * 2020-02-19 00:28
 *
 * @author yaoyy
 */
@Y
@Component
public class C {

	@Lookup
	public A a() {
		return null;
	}
}
