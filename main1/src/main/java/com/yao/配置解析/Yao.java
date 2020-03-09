package com.yao.配置解析;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@ComponentScan("com.yao")
public @interface Yao {

	@AliasFor(annotation = ComponentScan.class, value = "value")
	String value();
}
