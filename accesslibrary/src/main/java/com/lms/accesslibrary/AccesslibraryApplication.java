package com.lms.accesslibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.lms.accesslibrary.exception.ItemException;
import com.lms.accesslibrary.rent.Rental;

@SpringBootApplication
public class AccesslibraryApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AccesslibraryApplication.class, args);
		
		Rental rental = new Rental();
		try {
			rental.process();
		} catch (ItemException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AccesslibraryApplication.class);
    }

}
