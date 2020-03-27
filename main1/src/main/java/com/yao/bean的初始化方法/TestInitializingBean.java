package com.yao.bean的初始化方法;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 2020-03-02 14:33
 *
 * @author yaoyy
 */
@Component
public class TestInitializingBean implements InitializingBean, ImportAware {

	@PostConstruct
	public void init2() {
		System.out.println("@PostConstruct init2");
	}
	@PostConstruct
	public void init1() {
		System.out.println("@PostConstruct init1");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean");
	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		System.out.println(importMetadata.getAnnotationTypes());
	}
}
