package com.yao.transaction;

import org.apache.ibatis.annotations.Insert;

public interface BMapper {

	@Insert("insert into spring_transaction_b values(null, 'B', now())")
	void insertOrder();
}
