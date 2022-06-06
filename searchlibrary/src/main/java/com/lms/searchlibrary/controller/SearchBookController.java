package com.lms.searchlibrary.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.searchlibrary.bean.BookBean;
import com.lms.searchlibrary.service.ISearchService;

@RestController
@RequestMapping("/search")
public class SearchBookController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired	
	private ISearchService searchService;	
	
	@GetMapping("/searchallbooks")
	public List<BookBean> searchAllBooks(){
		logger.info("Search All Books in SearchBookController class is invoked.");		
		
		List<BookBean> books = searchService.getAllBooks();
		return books;
	};
	
	@GetMapping("/gettotalnumbooks")
	public int getTotalNumBooks(){
		logger.info("Get Total Num books in SearchBookController class is invoked.");		
		
		int totalNumBooks = searchService.getTotalNumBooks();
		return totalNumBooks;
	};
	
	@GetMapping("/searchbytitle/title/{title}")
	public List<BookBean> searchByTitle(@PathVariable String title){
		logger.info("Search By Title in SearchBookController class is invoked for the title "+title);		
		
		List<BookBean> books = searchService.searchByTitle(title);
		return books;
	};

	@GetMapping("/searchbyauthor/author/{author}")
	public List<BookBean> searchByAuthor(@PathVariable String author){
		logger.info("Search By Author in SearchBookController class is invoked for the author "+author);		
		
		List<BookBean> books = searchService.searchByAuthor(author);
		return books;
	};

	@GetMapping("/searchbysubject/subject/{subject}")
	public List<BookBean> searchBySubject(@PathVariable String subject){
		logger.info("Search By Subject in SearchBookController class is invoked for the subject "+subject);		
		
		List<BookBean> books = searchService.searchBySubject(subject);
		return books;
	};

	@GetMapping("/searchbypubdate/date/{date}")
	public List<BookBean> searchByPubDate(@PathVariable Date date){
		logger.info("Search By Publication Date in SearchBookController class is invoked for the publicationDate "+date);		
		
		List<BookBean> books = searchService.searchByPubDate(date);
		return books;
	};

}
