package com.yao.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

	/**
	 * 参数中的@Valid校验是由spring mvc的校验器进行校验的，当classpath中存在有java的Valid的spi时，校验器就会生效，所以只要引入了hibernate的
	 * 依赖（hibernate中有Valid的spi文件）,校验器就会自动生效
	 * {@link ModelAttributeMethodProcessor#validateIfApplicable(org.springframework.web.bind.WebDataBinder, org.springframework.core.MethodParameter)}
	 * 如果需要校验直接参数时，需要将MethodValidationPostProcessor引入带spring容器中（spring boot中好像已经将该postProcess初始引入到容器中了）
	 */
	@PostMapping("/test.do")
	public String hello(@Valid User user, @ModelAttribute(name = "nickname") String nickname) {
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
	 * 当controller中的handlerMethod执行抛出异常时，会优先寻找本controller的@ExceptionHandler方法，如果没有找到，
	 * 则会去符合条件的ControllerAdvice中找
	 * {@link org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver#getExceptionHandlerMethod(org.springframework.web.method.HandlerMethod, java.lang.Exception)}
	 * ControllerAdvice中的ExceptionHandler会预先解析，而本类中的ExceptionHandler则是抛出异常时事实解析
	 */
	@ExceptionHandler
	public String localExHandler(Exception e) {
		throw new IllegalStateException("");
//		return "local handler!";
	}
	@ExceptionHandler(IllegalStateException.class)
	public String IllegalStateExceptionHandler(Exception e) {
		return "捕获: " + e.getMessage();
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
