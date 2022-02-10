package com.yao.循环依赖;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * create by yaoyang on 2022/2/9
 */
@Component
@Order(1)
public class AsyncB {
	public AsyncB() {
		System.out.println("AsyncB");
	}

	@Autowired
	AsyncC asyncC;

	@Async
	public String hello() {
		return "d hello";
	}
}
