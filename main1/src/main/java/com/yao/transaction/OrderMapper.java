package com.yao.transaction;

import org.apache.ibatis.annotations.Insert;

public interface OrderMapper {

	@Insert("insert into spring_order values(null, 999, 1, 18.00, 1, now())")
	void insertOrder();
}
