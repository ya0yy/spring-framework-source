package com.yao.populate.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 2020-02-28 16:45
 *
 * @author yaoyy
 */
@Qualifier("a")
@Retention(RetentionPolicy.RUNTIME)
public @interface Ann1 {
}
