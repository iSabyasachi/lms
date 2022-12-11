package com.lms.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FrameworkApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FrameworkApplication.class, args);
	}
	
}
