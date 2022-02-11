package com.yao.循环依赖;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * create by yaoyang on 2022/2/9
 */
@Component
public class AsyncA {

	public AsyncA() {
		System.out.println("AsyncA");
	}

	@Autowired
	AsyncB asyncB;

	@Async
	public String hello() {
		return "d hello";
	}

}
