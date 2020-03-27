package com.yao.merged;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 2020-02-22 23:17
 *
 * 注意：@Resource方法的参数只能有一个，@Autowired没有限制，而且先执行@Resource的方法
 *
 * @author yaoyy
 */
public class ParentBean {

	@Autowired
	ParentBean(){}

	@Autowired
	A a;

	B b;

	String name;
	Double score;

	public String getName() {
		return name;
	}

	@Autowired
	public void re() {
		System.out.println("@Resource");
	}

	@Autowired
	public void setName(String name) {
		this.name = name;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
