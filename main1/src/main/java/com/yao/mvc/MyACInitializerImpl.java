package com.yao.mvc;

import javax.servlet.Servlet;

/**
 * 2020-02-24 01:54
 *
 * @author yaoyy
 */
public class MyACInitializerImpl implements MyACInitializer {

	public Servlet startUp() {
		return Mvc.initDispatcherServlet();
	}
}
