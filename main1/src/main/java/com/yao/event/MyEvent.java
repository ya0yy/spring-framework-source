package com.yao.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;
import org.springframework.stereotype.Component;

/**
 * 2020-04-03 01:26
 *
 * @author yaoyy
 */
public class MyEvent<T> extends ApplicationEvent implements ResolvableTypeProvider{

	public MyEvent(T entity) {
		super(entity);
	}

	/**
	 * 实现该接口可以是事件根据范型匹配
	 */
	public ResolvableType getResolvableType() {
		return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
	}
}
