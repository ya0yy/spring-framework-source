package com.yao.配置解析;

import com.yao.impo.ImportBeanDefinitionRegistrarA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 2020-03-02 16:41
 *
 * @author yaoyy
 */
@Configuration
@Import({ImportBeanDefinitionRegistrarA.class, TestImportNotRegistrar.class})
public class ParentAppRun {
	public ParentAppRun() {
		System.out.println("TestConfig0构造");
	}

	@Bean
	public String stringBean() {
		return "字符串bean";
	}
}
