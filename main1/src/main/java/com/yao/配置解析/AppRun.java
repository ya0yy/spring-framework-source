package com.yao.配置解析;

import com.yao.构造器推断.UserService;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

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
 * 2020-03-02 16:42
 *
 * @author yaoyy
 */
@Configuration
//@PropertySource("classpath:com/yao/properties.properties")
@PropertySource("classpath:properties.properties")
//@ComponentScan("com.yao com.mvc") // 解析为com.yao和com.mvc，分割符可用空格、回车、制表符
@ComponentScan(basePackageClasses = UserService.class) // 解析为该class所在的包
//@ComponentScan("${jack.ssss}") // 会从外部properties文件中解析值
//@ComponentScan("com.yao.配置解析")
@Conditional(AppRun.TestCondition.class)
public class AppRun extends TestConfig0{

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppRun.class);
	}

	public AppRun() {
		System.out.println("App Run!");
	}

	@Configuration
	static class AppRunMember {
		public AppRunMember() {
			System.out.println("AppRunMember Constructor!");
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
