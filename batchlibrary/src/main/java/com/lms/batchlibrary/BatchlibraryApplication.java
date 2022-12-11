package com.lms.batchlibrary;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchlibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchlibraryApplication.class, args);
	}

}
