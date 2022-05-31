package com.lms.accesslibrary.dao;

import java.util.List;

import com.lms.accesslibrary.entity.Book;

public interface iBookDAO {
	
	public Book insertBook(Book book);
	public Book updateBook(Book book);		
	public Book getBookById(long id);	
	public List<Book> getBookByType(String type);
	public void deleteBookById(int id);
	public Book getBookByBarcode(String barcode);
	public List<Book> getAllBooks();
	public List<Book> getAllBooksByUserId(long id);

}
