package com.lms.accesslibrary.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.accesslibrary.dao.BookDAO;
import com.lms.accesslibrary.dao.BookRepository;
import com.lms.accesslibrary.entity.book.Book;

@Component
public class BookBO {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookDAO bookDAO;
	
	public Book findByISBN(String isbn) {
		return bookRepository.findByISBN(isbn);
	};
	
	public Book findBybarcode(String barcode) {
		return bookRepository.findBybarcode(barcode);
	};

	public void save(Book book) {
		bookRepository.save(book);
	}
	
	public void delete(Book book) {
		bookRepository.delete(book);
	}
	
	public Book getBookById(long id) {		
		return bookDAO.getBookById(id);
	}
	
	public Book getBookByBarcode(String barcode) {		
		return bookDAO.getBookByBarcode(barcode);
	}
	
	public Book updateBook(Book book){
		return (Book) bookDAO.saveOrUpdate(book);
	};
	
	public List<Book> getBookByType(String type) {
		List<Book> books = bookDAO.getBookByType(type);
		return books;
	}
	public List<Book> getAllBooks() {
		List<Book> books = bookDAO.getAllBooks();
		return books;
	}
	public List<Book> getAllBooksByUserId(long id) {
		List<Book> books = bookDAO.getAllBooksByUserId(id);
		return books;
	}
	
}
