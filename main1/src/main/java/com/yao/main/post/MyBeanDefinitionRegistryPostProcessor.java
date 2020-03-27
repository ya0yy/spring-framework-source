package com.yao.main.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 2019-07-01 15:22
 *
 * @author yaoyy
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, Ordered {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(Wange2DogBeanDefinitionRegistryPostProcessor.class);
		registry.registerBeanDefinition("王二狗", bd);
		System.out.println("postProcessBeanDefinitionRegistry调用");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("postProcessBeanFactory调用");
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
