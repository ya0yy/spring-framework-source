package com.yao.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2020-02-15 23:32
 *
 * target()切点函数通过判断目标类是否按类型匹配指定类来决定连接点是否匹配. 用于匹配当前目标对象类型的执行方法；注意是目标对象的类型匹配；
 *
 * this()切点函数则通过判断代理类是否按类型匹配指定类来决定是否和切点匹配。 用于匹配当前AOP代理对象类型的执行方法；注意是AOP代理对象的类型匹配。 this中使用的表达式必须是类型全限定名，不支持通配符。
 *
 * @author yaoyy
 */
@Component
@Aspect
public class AspectClass {

	public static final String execution = "execution(public * com.yao..*(..))";

	public static final String target = "target(com.yao.aop.ProxyTarget)";

	public static final String _this = "this(com.yao.aop.ProxyTarget)";

	public static final String within = "@within(com.yao.aop.annotation.Y)";

	@Pointcut("this(com.yao.aop.ProxyTarget)")
	public void a() {
	}

//	public static final String targetSource = "target(org.springframework.aop.target.HotSwappableTargetSource)";

//	@Around(within)
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		Object r = pjp.proceed();
		System.out.println("around" + r);
		return 555;
	}

	@Around(execution)
	public void doAccessCheck(ProceedingJoinPoint point) {
		System.out.println("before");
	}
}
