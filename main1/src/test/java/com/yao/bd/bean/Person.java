package com.yao.bd.bean;

import org.springframework.stereotype.Component;

/**
 * 2020-02-09 15:21
 *
 * @author yaoyy
 */
@Component
public class Person {

	Car car;

	public void drive() {
		car.run();
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
