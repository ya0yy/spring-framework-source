package com.yao.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 2020-12-29 11:52
 *
 * @author yaoyy
 */
@Component
public class FilterTest extends GenericFilterBean {
	public FilterTest() {
		System.out.println("过滤器的构造器");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器");
	}
}
