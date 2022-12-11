package com.lms.accesslibrary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = { "classpath:config.properties" }, ignoreResourceNotFound = false)
public class LibraryConfig implements EnvironmentAware{
	@Autowired
	private static Environment env;
	
	public static String getProperty(String key) {
	    return env.getProperty(key);
	}
	
	@Override
	public void setEnvironment(Environment env) {
		LibraryConfig.env = env;
	}
}
