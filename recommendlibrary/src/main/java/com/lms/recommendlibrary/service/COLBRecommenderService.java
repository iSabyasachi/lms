package com.lms.recommendlibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lms.recommendlibrary.bean.BookBean;
import com.lms.recommendlibrary.bo.Filter;

@Service("COLBS")
public class COLBRecommenderService implements iRecommendService{
	
	//Ex. Field Injection
	@Autowired
	@Qualifier("COLBF")	
	Filter filter;
	
	public List<BookBean> recommendBooks (long userId) {		
		return filter.getRecommendations(userId);
	}
	
}
