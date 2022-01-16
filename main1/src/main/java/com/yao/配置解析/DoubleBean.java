package com.yao.配置解析;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * create by yaoyang on 2022/1/13
 */
@Configuration
@EnableAsync
public class DoubleBean {
	static {
		String path = "./main1/out/production/classes";
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);
		System.setProperty(net.sf.cglib.core.DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);
	}
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DoubleBean.class);
		DoubleBean bean = app.getBean(DoubleBean.class);
		bean.async1();
	}

	@Bean
	public String str1() {
		System.err.println("str1");
		return "str1";
	}
	@Bean
	public String str2() {
		str1();
		System.err.println("str2");
		return "str2";
	}

	@Async
	public void async1() {
		async2();
		System.out.println("async1====" + Thread.currentThread().getName());
	}
	@Async
	public void async2() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("async2===="  + Thread.currentThread().getName());
	}
}
