package com.lms.recommendlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RecommendlibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendlibraryApplication.class, args);
		
		//CBRecommenderService cbRecom = appContext.getBean(CBRecommenderService.class);
		
	}

}
