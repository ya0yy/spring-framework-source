package com.yao.构造器推断;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 2020-02-19 15:33
 *
 * @author yaoyy
 */
@Component
public class AutowireValueBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		Object userService = beanFactory.getBean("userService");
		ScannedGenericBeanDefinition bd = (ScannedGenericBeanDefinition) beanFactory.getBeanDefinition("userService");
//		bd.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
//		bd.setLenientConstructorResolution(false);
	}
}
