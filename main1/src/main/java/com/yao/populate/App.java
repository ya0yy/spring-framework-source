package com.yao.populate;

import com.yao.populate.bean.A;
import com.yao.populate.bean.C1;
import com.yao.populate.bean.ResourceBean;
import org.springframework.context.annotation.*;
import org.springframework.core.DefaultParameterNameDiscoverer;

/**
 * 2020-02-28 17:21
 *
 * @author yaoyy
 */
@ComponentScan("com.yao.populate")
@Configuration
@PropertySource("classpath:com/yao/properties.properties")
public class App {

	ResourceBean rb = new ResourceBean(this);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
		System.out.println(ac.getBean(A.class).b);
	}

	public ResourceBean getResourceBean() {
		return this.rb;
	}
}
