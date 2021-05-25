package com.yao.配置解析;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 2020-03-09 19:12
 *
 * @author yaoyy
 */
@Component
public class TestFactoryBean implements FactoryBean<Object> {

	@Override
	public Object getObject() throws Exception {
		return new ArrayList<>(8);
	}

	@Override
	public Class<?> getObjectType() {
		return ArrayList.class;
	}
}
