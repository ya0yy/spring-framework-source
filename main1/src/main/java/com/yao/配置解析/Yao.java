package com.yao.配置解析;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@ComponentScan("com.yao")
public @interface Yao {
}
