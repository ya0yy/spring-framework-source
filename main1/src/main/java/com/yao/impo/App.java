package com.yao.impo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 2020-02-11 01:36
 *
 * @author yaoyy
 */
@Configuration
@ComponentScan("com.yao.impo")
public class App {
	@Import(ImportBeanDefinitionRegistrarA.class)
	@Configuration
	static class SubApp {

	}
}
