package com.yao.scan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * 2019-06-25 21:33
 *
 * @author yaoyy
 */
public class Entrance {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Object.class);

		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
		// 可以自定义AnnotationTypeFilter，对包扫描进行扩展
		scanner.addIncludeFilter(new AnnotationTypeFilter(Y.class));
		int scan = scanner.scan("com.yao.scan");
		context.refresh();
		System.out.println(scan);

		Dao bean = context.getBean(Dao.class);
		bean.hello();

	}
}
