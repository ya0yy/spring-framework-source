package com.yao.main.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.Ordered;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2019-07-01 15:22
 *
 * 新增一个实现了Ordered接口的BeanDefinitionRegistryPostProcessor
 *
 * @author yaoyy
 */
public class Wange2DogBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, Ordered {

	static AtomicInteger i = new AtomicInteger();

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(Wange2DogBeanDefinitionRegistryPostProcessor.class);

		String myName = "王二狗" + i.incrementAndGet();

		registry.registerBeanDefinition(myName, bd);
		System.out.println(myName + "的postProcessBeanDefinitionRegistry调用");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("王二狗" + i.incrementAndGet() + "的postProcessBeanFactory调用");
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
