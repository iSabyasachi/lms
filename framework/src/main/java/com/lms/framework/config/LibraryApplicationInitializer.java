package com.lms.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class LibraryApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class aClass[] = { LibraryAppConfig.class };
	    return aClass;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[] = { "/lms/*" };
	    return arr;
	}

	

}
