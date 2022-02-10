package com.yao.循环依赖;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * create by yaoyang on 2022/2/9
 */
@Component
@Order(2)
public class AsyncC {
	public AsyncC() {
		System.out.println("AsyncC");
	}

	@Autowired
	AsyncA asyncA;
}
