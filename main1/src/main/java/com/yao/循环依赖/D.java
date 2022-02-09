package com.yao.循环依赖;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2020-02-14 00:42
 *
 * @author yaoyy
 */
@Component
public class D {

	@Autowired
	D d;

//	@Async
	D d(){return null;};

//	@Async
	public String hello() {
		return "d hello";
	}

	public void sayHello() {
		System.out.println(d().hello());
	}
}
