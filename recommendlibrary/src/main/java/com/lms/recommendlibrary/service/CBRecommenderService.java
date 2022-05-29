package com.lms.recommendlibrary.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lms.recommendlibrary.bean.BookBean;
import com.lms.recommendlibrary.bo.Filter;

@Service("CBS")	
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Primary
public class CBRecommenderService implements iRecommendService{	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Ex. Field Injection
	//@Autowired
	//@Qualifier("CBF")	
	Filter filter;
	
	//Autowire by Name
	//@Autowired
	//Filter contentBasedFilter;
		
	
	/*
	 * Ex. Setter Injection*/
	@Autowired
	@Qualifier("CBF")
	public void setFilter(Filter filter) {
		logger.info("1. In CBRecommenderService setter method.. dependecy injection.");
		this.filter = filter;
	}
	
	@PostConstruct
	public void postConstruct() {
		//Initialization code goes here
		logger.info("2. In CBRecommenderService post construct method.");
	}
	
	@PreDestroy
	public void preDestroy() {
		logger.info("5. In CBRecommenderService pre destory method.");
	}
	
	//@Autowired
	BookBean bookBean;
	
	//Ex. Autowire by Name
	//@Autowired
	//Filter collaborativeBasedFilter;
	/*
	 * Ex. Constructor Injection
	 * 
	@Autowired
	CBRecommenderService(@Qualifier("CBF") Filter filter){
		this.filter = filter;
	}*/
	
	/**
	 * @param book
	 * @return
	 */
	public List<BookBean> recommendBooks (long userId) {
		//use content based filter or collaborative based to find similar books
        //return the results
		return filter.getRecommendations(userId);
	}

	
	@Lookup
	public BookBean getBookBean() {
		return bookBean;
	}

	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}
	
}
