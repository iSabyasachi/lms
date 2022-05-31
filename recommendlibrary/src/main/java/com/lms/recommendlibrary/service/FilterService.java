package com.lms.recommendlibrary.service;

import java.util.List;

import com.lms.recommendlibrary.bean.BookBean;

public interface FilterService {
	public List<BookBean> getRecommendations(long userId);
}
