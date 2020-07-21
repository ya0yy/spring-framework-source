package com.yao.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 2020-04-03 01:07
 *
 * @author yaoyy
 */
@Configuration
@ComponentScan
@EnableAsync
public abstract class Main implements ApplicationEventPublisherAware {

	ApplicationEventPublisher publisher;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Main.class);
		Main main = ac.getBean(Main.class);
		main.publisher.publishEvent(new MyEvent<>("123"));
		System.out.println("main --");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
}
