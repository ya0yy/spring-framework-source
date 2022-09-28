package com.yao.util;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * create by yaoyang on 2022/2/14
 */
public class ResolvableTypeTest<T> {

	List<T> genericList;

	public ResolvableTypeTest() {
		Type superClass = getClass().getGenericSuperclass();
		if (superClass instanceof Class<?>) { // sanity check, should never happen
			throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
		}
		/* 22-Dec-2008, tatu: Not sure if this case is safe -- I suspect
		 *   it is possible to make it fail?
		 *   But let's deal with specific
		 *   case when we know an actual use case, and thereby suitable
		 *   workarounds for valid case(s) and/or error to throw
		 *   on invalid one(s).
		 */
		Type actualTypeArgument = ((ParameterizedType) superClass).getActualTypeArguments()[0];
		System.out.println(actualTypeArgument);
	}

	List<Double> member;

	public static void main(String[] args) throws Exception {
		Class<ResolvableTypeTest> resolvableTypeTestClass = ResolvableTypeTest.class;
		Method testedMethod = resolvableTypeTestClass.getMethod("testedMethod", List.class);

		// for return value
		ResolvableType resolvableType = ResolvableType.forMethodReturnType(testedMethod);
		System.out.println( resolvableType.resolveGeneric());

		// for parameter
		resolvableType = ResolvableType.forMethodParameter(testedMethod, 0);
		System.out.println(resolvableType.getGeneric());

		// for member
		resolvableType = ResolvableType.forField(ResolvableTypeTest.class.getDeclaredField("member"));
		System.out.println(resolvableType.getGeneric());

		// for member
		ResolvableTypeTest<Map<List<StringBuilder>, Object>> objectResolvableTypeTest = new ResolvableTypeTest<Map<List<StringBuilder>, Object>>(){};
		resolvableType = ResolvableType.forType(objectResolvableTypeTest.getClass().getGenericSuperclass());
		System.out.println(resolvableType.getGeneric());
	}

	public List<String> testedMethod(List<Integer> list) {
		return null;
	}

}
