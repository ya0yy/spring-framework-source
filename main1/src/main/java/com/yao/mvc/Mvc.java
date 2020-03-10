package com.yao.mvc;

import com.sun.javafx.runtime.SystemProperties;
import org.apache.catalina.*;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.servlet.Servlet;
import java.util.List;

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
 * 2020-02-23 23:36
 *
 * 0配置mvc
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

		return new DispatcherServlet(ac);
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
				return null;
			}

			@Override
			public MessageCodesResolver getMessageCodesResolver() {
				return null;
			}
		};
	}
}
