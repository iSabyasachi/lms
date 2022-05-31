package com.lms.recommendlibrary.dto;

import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(books, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recommendation other = (Recommendation) obj;
		return Objects.equals(books, other.books) && Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "Recommendation [message=" + message + ", books=" + books + ", port=" + port + "]";
	}

	
	

}
