package com.yao.main;

import com.yao.main.config.App;
import com.yao.scan.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2019-06-25 21:33
 *
 * @author yaoyy
 */
public class Entrance {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		Dao bean = context.getBean(Dao.class);
		bean.hello();

	}
}
