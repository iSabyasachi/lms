package com.lms.recommendlibrary.bo;

import java.util.List;

import com.lms.recommendlibrary.bean.BookBean;

public interface Filter {
	public List<BookBean> getRecommendations(long userId);
}
