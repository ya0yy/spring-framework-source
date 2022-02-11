package com.yao.transaction;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2020-03-27 00:55
 *
 * @author yaoyy
 */
@Service
public class AService {

	public AService() {
		System.out.println();
	}

	@Autowired
	AMapper a;

	@Autowired
	BService b;
	@Autowired
	AService aService;

	@Transactional
	public void insert() {
		System.out.println(this.getClass());
		a.insert();
		try {
			((AService) AopContext.currentProxy()).insert0();
//			insert0();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insert0() {
		System.out.println(this.getClass());
		a.insert0();
		throw new RuntimeException();
	}
}
