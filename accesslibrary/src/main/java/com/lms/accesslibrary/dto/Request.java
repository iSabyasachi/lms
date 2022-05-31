package com.lms.accesslibrary.dto;

import org.springframework.stereotype.Component;

import com.lms.accesslibrary.entity.Book;
import com.lms.accesslibrary.entity.BookItem;
import com.lms.accesslibrary.entity.User;

import lombok.Data;

@Data
@Component
public class Request {
	private User member;
	private User librarian;
	private Book book;
	private BookItem bookItem;
	public User getMember() {
		return member;
	}
	public void setMember(User member) {
		this.member = member;
	}
	public User getLibrarian() {
		return librarian;
	}
	public void setLibrarian(User librarian) {
		this.librarian = librarian;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookItem getBookItem() {
		return bookItem;
	}
	public void setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
	}
}
