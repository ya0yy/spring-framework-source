package com.yao.bd;

import com.yao.bd.bean.Car;
import com.yao.bd.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2020-02-09 15:14
 *
 * @author yaoyy
 */
public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Person person = context.getBean(Person.class);
		person.drive();
	}
}
