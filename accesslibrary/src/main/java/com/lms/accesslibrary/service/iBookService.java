package com.lms.accesslibrary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.accesslibrary.bean.BookBean;
import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;
import com.lms.accesslibrary.entity.book.Book;

@Service
public interface iBookService {
	public Response addBook(Request request);
	public Response removeBook(Request request);
	public BookBean getBookById(long id);
	public BookBean getBookByBarcode(String barcode);
	public Response updateBook(Request request);
	public List<BookBean> getBookByType(String type);
	public List<BookBean> getAllBooks();
	public List<BookBean> getAllBooksByUserId(long id);
}
