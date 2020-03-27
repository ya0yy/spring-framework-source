package com.yao.main;

import com.yao.scan.Dao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2019-06-27 15:48
 *
 * @author yaoyy
 */
public class XmlEntrance {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("com/yao/spring.xml");
		Dao bean = classPathXmlApplicationContext.getBean(Dao.class);
		bean.hello();
	}
}
