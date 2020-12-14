package com.yao.scheduled;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * @author yaoyy
 */
@Configuration
@EnableScheduling
public class Entrance {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Entrance.class);

	}

	@Scheduled(fixedDelay = 5000)
	public void sayHello() {
		System.out.println("HELLO SCHEDULED !");
	}
}
