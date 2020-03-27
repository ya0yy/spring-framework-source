package com.yao.配置解析;

import com.yao.impo.ImportBeanDefinitionRegistrarA;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.ArrayList;

/**
 * 2020-03-02 16:42
 *
 * @author yaoyy
 */
@Configuration
//@PropertySource("classpath:com/yao/properties.properties")
@PropertySource("classpath:properties.properties")
//@ComponentScan("com.yao com.mvc") // 解析为com.yao和com.mvc，分割符可用空格、回车、制表符
//@ComponentScan(basePackageClasses = UserService.class) // 解析为该class所在的包
//@ComponentScan("${jack.ssss}") // 会从外部properties文件中解析值
@ComponentScan(value = "com.yao.配置解析", scopedProxy = ScopedProxyMode.TARGET_CLASS)
@Conditional(AppRun.TestCondition.class)
//@Yao("包扫描") // 拿到不@Yao里的@ComponentScan注解
/**
 * 对于一个配置类的超类，如果该超类也是以一个配置类，则该超类会被解析两次，一次是@ComponentScan包扫描，第二次是配置类（也就是本类）的父类解析，
 * 两次解析到的结果一个存在本类中，一个存在父类的配置类中，所以在父类中的@Import会被实例化两次，执行两次，但是@Bean方法是被代理的，调用@Bean时候，
 * 只要是full配置类并且是容器中已经存在的bean，就不会再调用该方法，会直接从容器中getBean然后return
 */
public class AppRun extends ParentAppRun {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppRun.class);
		/**
		 * getBean根据类型获取会先根据类型获取到beanName，因为一个类型可能对应多个bean，遍历匹配类型，找出所有该类型的beanName，然后根据beanName去getBean
		 */
//		ac.getBean("&testFactoryBean");
		ac.getBean(ArrayList.class);
	}

	public AppRun() {
		System.out.println("App Run!");
	}

	/**
	 * 如果包扫描有配置到这个内部配置类的路径，则会扫描到该配置类两次，第一次是解析一个配置类的内部成员类，第二次是@ComponentScan扫描包下的配置类，第二次解析的结果会覆盖第一次
	 *
	 * 扫描的时候会实例化@Import的BeanDefinitionRegistrar，所以此处的ImportBeanDefinitionRegistrarA会被实例化两次，第二次会覆盖第一次，只会执行一次
	 */
	@Import({ImportBeanDefinitionRegistrarA.class, TestImportNotRegistrar.class})
	@Configuration
	static class AppRunMember {

		public AppRunMember() {
			System.out.println("AppRunMember Constructor!");
		}
		@Bean("str1")
		public String str1() {
			return "str one";
		}
		@Bean("str0")
		public String str0() {
			return "str zero";
		}
		@Bean("int2")
		public Integer str2() {
			return 2;
		}
	}

	@Bean("mainString")
	public String s() {
		return "main string";
	}

	static class TestCondition implements Condition {
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			return true;
		}
	}
}
