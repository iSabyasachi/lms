package com.lms.recommendlibrary.dto;

import com.lms.recommendlibrary.bean.BookBean;

public class Recommendation {
	
	private String message;
	private BookBean book;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}

}
