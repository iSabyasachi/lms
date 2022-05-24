package com.lms.accesslibrary.dto;

import org.springframework.stereotype.Component;

import com.lms.accesslibrary.entity.library.book.Book;
import com.lms.accesslibrary.entity.library.book.BookItem;
import com.lms.accesslibrary.entity.library.user.User;

import lombok.Data;

@Data
@Component
public class Checkout extends Request{	
	private BookItem bookItem;
	
	public BookItem getBookItem() {
		return bookItem;
	}
	public void setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
	}
}
