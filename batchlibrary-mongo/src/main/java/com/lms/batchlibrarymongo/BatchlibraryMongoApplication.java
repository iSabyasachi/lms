package com.lms.batchlibrarymongo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.lms.batchlibrarymongo.model.UserAddress;
import com.lms.batchlibrarymongo.model.UserDetail;

@EnableMongoAuditing
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableBatchProcessing
public class BatchlibraryMongoApplication {
	
	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(BatchlibraryMongoApplication.class, args);
		
		//Find all the beans managed by Spring
		displayAllBean();
		
	}
	public static void displayAllBean() {
		UserDetail obj1 = applicationContext.getBean(UserDetail.class);
		UserDetail obj2 = applicationContext.getBean(UserDetail.class);
		System.out.println(obj1);
		System.out.println(obj2);
		
		UserAddress obj3 = applicationContext.getBean(UserAddress.class);
		UserAddress obj4 = applicationContext.getBean(UserAddress.class);
		System.out.println(obj3);
		System.out.println(obj4);
		
		System.out.println("\nUserDetail instances created: "+
				UserDetail.getInstances());
		System.out.println("UserAddress instances created: "+ UserAddress.getInstances());
	}

}
