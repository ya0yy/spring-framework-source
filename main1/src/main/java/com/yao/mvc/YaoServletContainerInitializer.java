package com.yao.mvc;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * 2020-02-24 01:50
 *
 * @author yaoyy
 */
@HandlesTypes(MyACInitializer.class)
public class YaoServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		System.out.println("onStartup");
		for (Class<?> clazz : c) {
			try {
				System.out.println(clazz);
				MyACInitializer initializer = (MyACInitializer) clazz.newInstance();

				ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", initializer.startUp());
				servlet.addMapping("*.do");
				servlet.setLoadOnStartup(1);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}
	}
}
