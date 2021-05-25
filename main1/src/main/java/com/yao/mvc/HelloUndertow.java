package com.yao.mvc;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.SetHeaderHandler;
import io.undertow.server.handlers.proxy.LoadBalancingProxyClient;
import io.undertow.server.handlers.proxy.ProxyHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

public class HelloUndertow {

	public static void main(final String[] args) throws ServletException {
		DeploymentInfo servletBuilder = Servlets.deployment()
				.setClassLoader(HelloUndertow.class.getClassLoader())
				.setContextPath("/myapp")
				.setDeploymentName("test.war")
				.addServlets(
						Servlets.servlet("MessageServlet", MessageServlet.class)
								.addInitParam("message", "Hello World")
								.addMapping("/*"),
						Servlets.servlet("MyServlet", MessageServlet.class)
								.addInitParam("message", "MyServlet")
								.addMapping("/myservlet"));

		DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
		manager.deploy();

		PathHandler path = Handlers.path(manager.start());

		SetHeaderHandler handler = new SetHeaderHandler(path, "wbdz", "wangbaduzidezhi");

		MyProxyClient myProxyClient = new MyProxyClient();
		myProxyClient.addHost(URI.create("http://192.168.109.132:90"));

		ProxyHandler proxyHandler = Handlers.proxyHandler(myProxyClient, handler);

		Undertow server = Undertow.builder()
				.addHttpListener(8080, "localhost")
				.setHandler(proxyHandler)
				.build();
		server.start();
	}

	static class MyProxyClient extends LoadBalancingProxyClient {
		@Override
		public ProxyTarget findTarget(HttpServerExchange exchange) {
			if ("/xxx".equals(exchange.getRequestPath())) {
				return super.findTarget(exchange);
			}
			return null;
		}
	}

	static class MessageServlet extends HttpServlet {
		public static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) {
			String 从此君王不早朝 = "从此君王不早朝";
			System.out.println(从此君王不早朝);
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=utf-8");

				response.getWriter().write(从此君王不早朝);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
