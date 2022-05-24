package com.lms.accesslibrary.service;

import org.springframework.stereotype.Service;

import com.lms.accesslibrary.bean.BookBean;
import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;

@Service
public interface iBookService {
	public Response addBook(Request request);
	public Response removeBook(Request request);
	public BookBean getBookById(long id);
	public BookBean getBookByBarcode(String barcode);
	public Response updateBook(Request request);
}
