package com.yao.transaction;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 2020-03-27 00:32
 *
 * @author yaoyy
 */
@MapperScan
@ComponentScan
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
public class MainConfig {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
		AService itemService = ac.getBean(AService.class);
		BService orderService = ac.getBean(BService.class);
		itemService.insert();
	}

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://192.168.109.132:3306/spring_test", "root", "admin");
	}

	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		DataSource dataSource = dataSource();
		dataSource.getConnection().createStatement().execute("TRUNCATE spring_transaction_a;");
		dataSource.getConnection().createStatement().execute("TRUNCATE spring_transaction_b;");
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		return factoryBean.getObject();
	}
}
