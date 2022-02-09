package com.yao.mvc;

import org.apache.catalina.*;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 2020-02-23 23:36
 *
 * 0配置mvc
 *
 *
 *
 * springmvc整合tomcat流程分析
 * tomcat启动时候，servlet3.0规范会扫描javax.servlet.ServletContainerInitializer的spi文件，然后获取类上面的@HandlerType注解所标注的
 * 类型的所有class，执行onStartup方法。
 * 此时可以在onStartup中将SpringMvc的核心DispatcherServlet初始化，然后放到ServletContext中
 * 当ServletContext容器初始化DispatcherServlet时，会调用它所覆写的init方法{@link HttpServletBean#init()}，
 * 然后会执行到子类的{@link FrameworkServlet#initServletBean()}，在这个方法中初始化了Spring web context环境
 *
 * @author yaoyy
 */
@ComponentScan("com.yao.mvc")
@Configuration
@EnableWebMvc
public class Mvc {

	public static void main(String[] args) throws Exception {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8082);
		Context context = tomcat.addContext("/a", "/Users/yaoyang/IdeaProjects/spring-framework/tomcat.8082/");
//		tomcat.addServlet("/a", "dispatcher", initDispatcherServlet()).setStartStopThreads(1);
//		context.addServletMappingDecoded("*.do", "dispatcher");
		// 执行tomcat生命周期
		context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());
		try {
			// tomcat9.0要显式调用getConnector才能监听端口
			tomcat.getConnector();
			tomcat.start();
			tomcat.getServer().await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Servlet initDispatcherServlet() {
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(Mvc.class);

		// DispatchServlet是一个Servlet，并不是SpringContext，只是ServletContext中包含了一个SpringContext
		return new DispatcherServlet(ac);
	}

//	@Bean
	public static MethodValidationPostProcessor methodValidationPostProcessor(Environment environment) {
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.afterPropertiesSet();
		MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
		boolean proxyTargetClass = environment.getProperty("spring.aop.proxy-target-class", Boolean.class, true);
		processor.setProxyTargetClass(proxyTargetClass);
		processor.setValidator(factoryBean);
		processor.setValidatedAnnotationType(Controller.class);
		return processor;
	}

	@Bean
	public WebMvcConfigurer mvcConfig() {
		return new WebMvcConfigurer() {
			@Override
			public void configurePathMatch(PathMatchConfigurer configurer) {

			}

			@Override
			public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

			}

			@Override
			public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

			}

			@Override
			public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

			}

			@Override
			public void addFormatters(FormatterRegistry registry) {

			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new HandlerInterceptor(){});
			}

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {

			}

			@Override
			public void addCorsMappings(CorsRegistry registry) {

			}

			@Override
			public void addViewControllers(ViewControllerRegistry registry) {

			}

			@Override
			public void configureViewResolvers(ViewResolverRegistry registry) {

			}

			@Override
			public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
				resolvers.add(new MyArgumentResolver());

			}

			@Override
			public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

			}

			@Override
			public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

			}

			@Override
			public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

			}

			@Override
			public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

			}

			@Override
			public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

			}

			@Override
			public Validator getValidator() {
				LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
				localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
				return localValidatorFactoryBean;
			}

			@Override
			public MessageCodesResolver getMessageCodesResolver() {
				return null;
			}
		};
	}
}
