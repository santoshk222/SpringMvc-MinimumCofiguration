package com.sk.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	final Logger logger = Logger.getLogger(getClass());
	String log = WebAppInitializer.class + " ";

	@Override
	protected Class<?>[] getRootConfigClasses() {
		logger.debug(log + "getRootConfigClasses() ");
		return new Class[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		logger.debug(log + "getServletConfigClasses()");
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		logger.debug(log + "returned '/'");
		return new String[] { "/" };
	}

}
