package com.lms.accesslibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AccesslibraryApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AccesslibraryApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AccesslibraryApplication.class);
    }

}
