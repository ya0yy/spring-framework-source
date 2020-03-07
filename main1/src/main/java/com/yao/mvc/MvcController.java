package com.yao.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
 * 2020-02-24 00:18
 *
 * @author yaoyy
 */
@RestController
@RequestMapping(value = "/test")
public class MvcController {

	@Autowired
	public void xx() {
		System.out.println("sxx");
	}


	public MvcController() {
		System.out.println("MvcController构造");
	}

	@GetMapping("/test.do")
	public String hello(User user, @ModelAttribute(name = "nickname") String nickname) {
		return user  + "======" + nickname;
	}

	@ModelAttribute(name = "nickname")
	public String getNickname(Model model) {
		return "tom";
	}


	/**
	 * 其实initBinder类似一个Controller级别的参数解析器
	 * @param binder 。
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.setDisallowedFields("nickname", "name");
	}

	static class User {
		private String name;
		private String nickname;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		@Override
		public String toString() {
			return "User{" +
					"name='" + name + '\'' +
					", nickname='" + nickname + '\'' +
					'}';
		}
	}
}
