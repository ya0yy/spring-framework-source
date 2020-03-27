package com.yao.main.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * 2019-06-25 22:41
 *
 * @author yaoyy
 */
@Repository
public class Dao {

	@Value("hello")
	private String s;

//	public Dao() {
//		System.out.println("Dao被初始化了");
//	}

	public void hello() {
		System.out.println("调用hello()方法");
	}
}
