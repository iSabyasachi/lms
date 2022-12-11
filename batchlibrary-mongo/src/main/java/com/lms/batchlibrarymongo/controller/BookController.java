package com.lms.batchlibrarymongo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.batchlibrarymongo.domain.Book;
import com.lms.batchlibrarymongo.repository.BookRepository;
import com.lms.batchlibrarymongo.service.BookService;

@RestController
@RequestMapping("/batch")
public class BookController {
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job bookJob;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/loadbook")
	public BatchStatus loadBook() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(maps);		
		JobExecution jobExecution = jobLauncher.run(bookJob, jobParameters);
		
		System.out.println("JobExecution: "+ jobExecution.getStatus());
		while(jobExecution.isRunning()) {
			System.out.println("...");
		}
		
		return jobExecution.getStatus();
	}
	
	@GetMapping("/get/id/{id}")
	public Book getBook(@PathVariable long id) {
		return bookService.getBook(id);
	}
}
