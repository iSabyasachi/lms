package com.lms.recommendlibrary.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.recommendlibrary.bean.BookBean;
import com.lms.recommendlibrary.proxy.AccessLibraryProxy;

@Service("COLBF")
//@Primary
public class CollaborativeBasedFilter implements Filter{
	
	@Autowired
	private AccessLibraryProxy accessLibraryProxy;
	
	public List<BookBean> getRecommendations(long userId) {
		//logic of collaborative based filter
		
		List<BookBean> bookBeans = accessLibraryProxy.getAllBooksByUserId(userId);		
		return bookBeans;
	}
}
