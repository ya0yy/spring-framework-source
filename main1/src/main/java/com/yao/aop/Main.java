package com.yao.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.context.annotation.*;

/**
 * 　　　　　　　 ┏┓　 ┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　┃
 * 　　　　　　　┃　　　━　　 ┃ ++ + + +
 * 　　　　　　 ████━████  ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　 ┃　　　┃
 * 　　　　　　　　 ┃　　　┃ + + + +
 * 　　　　　　　　 ┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　 ┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　 ┃　　　┃
 * 　　　　　　　　 ┃　　　┃　　+
 * 　　　　　　　　 ┃　 　 ┗━━━┓ + +
 * 　　　　　　　　 ┃ 　　　　   ┣┓
 * 　　　　　　　　 ┃ 　　　　　 ┏┛
 * 　　　　　　　　 ┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　  ┃┫┫ ┃┫┫
 * 　　　　　　　　  ┗┻┛ ┗┻┛+ + + +
 * <p>
 * spring
 * 2020-02-12 23:24
 *
 * @author yaoyy
 */
@ComponentScan("com.yao.aop")
@Configuration
@EnableAspectJAutoProxy
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//		ProxyTarget bean = context.getBean(ProxyTarget.class);
		A a = context.getBean(A.class);
		a.getB().sout();
//		I bean = context.getBean(I.class);
//		bean.m1();
//		bean.i();
	}

//	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//		ProxyTarget bean = context.getBean(ProxyTarget.class);
//		HotSwappableTargetSource swapper = context.getBean(HotSwappableTargetSource.class);
//		bean.m2();
//		swapper.swap(new ProxyTarget("new"));
//		bean.m2();
//	}
//
//	@Bean
//	public HotSwappableTargetSource swapper() {
//		return new HotSwappableTargetSource(new ProxyTarget());
//	}
//
//	@Bean
//	public ProxyFactoryBean swappable(HotSwappableTargetSource swapper) {
//		ProxyFactoryBean bean = new ProxyFactoryBean();
//		bean.setTargetSource(swapper);
//		return bean;
//	}

}
