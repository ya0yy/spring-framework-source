package com.yao.impo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * 2020-02-11 01:37
 *
 * 如果不是@Import的就不会执行ImportBeanDefinitionRegistrar的方法，并且实现ImportBeanDefinitionRegistrar接口后不会将该类视为bean，源码中是直接new出实例执行方法
 *
 * @author yaoyy
 */
//@Component
public class ImportBeanDefinitionRegistrarA implements ImportBeanDefinitionRegistrar {

	public ImportBeanDefinitionRegistrarA() {
		System.out.println("ImportBeanDefinitionRegistrarA 构造");
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		System.out.println("@Import registerBeanDefinitions 执行 方法一");
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println("方法二");
	}
}
