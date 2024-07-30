package com.jsp.foodapp.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.jsp")
public class ConfigurationClass {

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver() ;
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/");
		return resolver ;
	}
	
	@Bean
	public EntityManagerFactory getEmf() {
		return Persistence.createEntityManagerFactory("dev") ;
	}
}
