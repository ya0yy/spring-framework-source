package com.yao.transaction;

import org.apache.ibatis.annotations.Insert;

/**
 * 2020-03-27 00:50
 *
 * @author yaoyy
 */
public interface AMapper {

	@Insert("insert into spring_transaction_a values(null, '小毛铺', now())")
	void insert();

	@Insert("insert into spring_transaction_a values(null, '苦荞酒', now())")
	void insert0();
}
