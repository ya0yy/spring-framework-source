package com.yao.populate.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 2020-02-28 17:13
 *
 * 注解@Qualifier只能解析到两层
 *
 * @author yaoyy
 */
@Component
@Qualifier("1")
public class B implements D {

}
