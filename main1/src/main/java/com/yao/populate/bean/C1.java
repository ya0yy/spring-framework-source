package com.yao.populate.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 2020-03-01 15:29
 *
 * @author yaoyy
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class C1 extends C {
}
