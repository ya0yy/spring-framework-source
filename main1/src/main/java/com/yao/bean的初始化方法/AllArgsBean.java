package com.yao.bean的初始化方法;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * create by yaoyang on 2022/8/1
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class AllArgsBean {

	private final ApplicationContext ac;
	private final Long id;

	public AllArgsBean(ApplicationContext ac, Long id) {
		this.ac = ac;
		this.id = id;
	}
}
