package com.lms.recommendlibrary.dto;

import java.util.List;

import com.lms.recommendlibrary.bean.BookBean;

public class Recommendation {
	
	private String message;
	private List<BookBean> books;
	private String port;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<BookBean> getBooks() {
		return books;
	}

	public void setBooks(List<BookBean> books) {
		this.books = books;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	

	

}
