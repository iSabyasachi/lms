package com.lms.recommendlibrary.service;

import java.util.List;

import com.lms.recommendlibrary.bean.BookBean;

public interface iRecommendService {
	
	/*
	 * use content based filter or collaborative based to find similar books
     * return the results
	 * */
	public List<BookBean> recommendBooks (long userId);

}
