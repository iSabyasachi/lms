package com.lms.accesslibrary.dto;

import org.springframework.stereotype.Component;

import com.lms.accesslibrary.bean.BookBean;

import lombok.Data;

@Data
@Component
public class Response {
	
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
