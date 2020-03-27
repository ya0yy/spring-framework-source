package com.yao.populate.component;

import com.yao.merged.A;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 2020-02-28 16:12
 *
 * @author yaoyy
 */
//@Component("a")
public class AFactoryBean implements FactoryBean<A> {

	@Override
	public A getObject() throws Exception {
		return new A();
	}

	@Override
	public Class<A> getObjectType() {
		return A.class;
	}
}
