package com.lms.recommendlibrary.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lms.recommendlibrary.bean.BookBean;
import com.lms.recommendlibrary.proxy.AccessLibraryProxy;

@Service("CBF")
@Primary
public class ContentBasedFilterService implements FilterService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccessLibraryProxy accessLibraryProxy;	
	
	
	public List<BookBean> getRecommendations(long userId) {
		//logic of content based filter
		List<BookBean> bookBeans = accessLibraryProxy.getAllBooksByUserId(userId);		
        return bookBeans;
	}

}
