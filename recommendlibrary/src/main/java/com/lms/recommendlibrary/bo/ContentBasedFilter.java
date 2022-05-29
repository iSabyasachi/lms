package com.lms.recommendlibrary.bo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.recommendlibrary.bean.BookBean;
import com.lms.recommendlibrary.dto.Recommendation;
import com.lms.recommendlibrary.proxy.AccessLibraryProxy;

@Service("CBF")
//@Primary
public class ContentBasedFilter implements Filter{
	
	@Autowired
	private AccessLibraryProxy accessLibraryProxy;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public ContentBasedFilter() {
		super();
		logger.info("3. In ContentBasedFilter constructor method.");
	}
	
	@PostConstruct
	public void postConstruct() {
		logger.info("4. In ContentBasedFilter post constructor method.");
	}
	
	@PreDestroy
	public void preDestroy() {
		logger.info("6. In ContentBasedFilter pre destory method.");
	}
	
	public List<BookBean> getRecommendations(long userId) {
		//logic of content based filter
		List<BookBean> bookBeans = accessLibraryProxy.getAllBooksByUserId(userId);		
        return bookBeans;
	}

}
