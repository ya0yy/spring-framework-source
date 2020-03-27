package com.yao.log;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * 2020-03-25 22:25
 *
 * @author yaoyy
 */
@Configuration
public class LogTest {
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(args));
		System.setProperty(".level", "ALL");
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LogTest.class);
		ac.start();
	}


	static class MyLogManager extends LogManager {
		@Override
		public void readConfiguration(InputStream ins) throws IOException, SecurityException {

		}
	}
}
