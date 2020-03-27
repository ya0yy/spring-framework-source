package com.yao.bean的初始化方法;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 2020-03-09 19:12
 *
 * @author yaoyy
 */
@Component
public class TestFactoryBean implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		return new ArrayList(8);
	}

	@Override
	public Class<?> getObjectType() {
		return ArrayList.class;
	}
}
