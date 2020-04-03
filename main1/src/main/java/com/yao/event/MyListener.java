package com.yao.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 2020-04-03 01:08
 *
 * @author yaoyy
 */
@Component
public class MyListener {

	/**
	 * 监听到事件并不是异步执的哦
	 * @param event
	 */
	@Async
	@EventListener
	public void customListener(MyEvent<String> event) {
		System.out.println(event.getSource().getClass());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
