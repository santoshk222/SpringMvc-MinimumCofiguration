package com.sk.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author santosh
 * This class is equavalent to spring-servlet.xml
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.sk.web","com.sk.security"})
public class WebConfig implements WebMvcConfigurer{

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		
	}
	

	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	

}
