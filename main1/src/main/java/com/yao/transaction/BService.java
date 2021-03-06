package com.yao.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.*;

/**
 * 2020-03-27 00:55
 *
 * @author yaoyy
 */
@Service
public class BService {

	@Autowired
	BMapper orderMapper;

	@Transactional(propagation = REQUIRES_NEW)
	public void insert() {
		orderMapper.insertOrder();
		throw new RuntimeException();
	}
}
