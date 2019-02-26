package com.sk.config;

import org.apache.log4j.Logger;
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
 * @author santosh This class is equavalent to spring-servlet.xml
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.sk.web", "com.sk.security" })
public class WebConfig implements WebMvcConfigurer {

	final Logger logger = Logger.getLogger(getClass());
	String log = WebConfig.class + "-";

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
		viewResolver.setViewClass(JstlView.class);
		logger.debug(log + "returned viewResolver");
		return viewResolver;
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		logger.debug(log + "added view controller 'home'");

	}

	public void configureViewResolvers(ViewResolverRegistry registry) {
		logger.debug(log + "configureViewResolvers");
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

}
