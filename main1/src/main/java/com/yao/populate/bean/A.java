package com.yao.populate.bean;

import com.yao.populate.annotation.Ann3;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 2020-02-28 17:13
 *
 * @author yaoyy
 */
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class A {

	/**
	 * Resource注解会按照指定的name去查找，如果未指定name，则会按照@Autowired注解的逻辑去查找
	 * 如果beanName为name的bean存在，则通过字段类型和name去getBean，但是这里app和resourceBean的类型不匹配，在Spring getBean方法里
	 * 找到bean之后会匹配一遍类型，如果类型不匹配会通过类型转换器转换，默认的类型转换器是该class全限定名+"Editor"，如果没有匹配的类型转换器则会抛出bean类型不匹配异常
	 */
	@Resource(name = "app")
	ResourceBean resourceBean;

	//	@Value("jack.name")
	String str;

		@Value("#{c}")
//	@Value("${bean.name}")
//	@Autowired
	public D c;

	@Ann3
	@Autowired
	public B b;

	@Autowired
//	@Qualifier("b")
	public B b(@Qualifier("b") B b) {
		return b;
	}

	/**
	 * Map、Collection会根据范型注入bean，数组根据数组类型
	 */
	@Autowired
//			@Qualifier("b1")
	public Map<String, ? extends D> map;

	@Autowired
	public List<D> list;

	/**
	 * Optional根据范型注入bean
	 */
//	@Autowired
	public Optional<B> b1;

	/**
	 * 根据范型注入bean
	 * 类似与@Lookup，每次从工厂中获取的对象的生命周期是取决于该bean的scope的
	 */
//	@Autowired
	public ObjectFactory<C> c1;

	/**
	 * 字段上加@Lazy，spring在创建bean a的注入c2的时候注入一个cglibe代理的临时对象，在创建bean c2的时候会真正创建c2
	 */
	@Autowired
	@Lazy
	public C2 c2;
}
