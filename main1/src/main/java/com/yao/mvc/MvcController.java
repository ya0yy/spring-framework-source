package com.yao.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * 2020-02-24 00:18
 *
 * @author yaoyy
 */
@RestController("/mvc")
@RequestMapping(value = "/test")
public class MvcController extends AbstractController {

	@Autowired
	public void xx() {
		System.out.println("sxx");
	}


	public MvcController() {
		System.out.println("MvcController构造");
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.err.println("命中！");
		return null;
	}

	@GetMapping("/test.do")
	public String hello(@Validated User user, @ModelAttribute(name = "nickname") String nickname) {
		return user  + "======" + nickname;
	}

	@GetMapping("/throw_exp.do")
	public void throwExp() {
		throw new RuntimeException();
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

	public static class User {
		@NotNull(message = "name不能为null")
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
