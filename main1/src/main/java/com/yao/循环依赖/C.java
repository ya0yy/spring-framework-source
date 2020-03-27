package com.yao.循环依赖;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2020-02-12 23:29
 *
 * @author yaoyy
 */
@Component
public class C {
	@Autowired
	A c;

	public C() {
		System.out.println("C");
	}
}
