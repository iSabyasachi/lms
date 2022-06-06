package com.lms.searchlibrary.service;

import java.util.Date;
import java.util.List;

import com.lms.searchlibrary.bean.BookBean;

public interface ISearchService {
	
	public List<BookBean> searchByTitle(String title);

	
	public List<BookBean> searchByAuthor(String author);

	
	public List<BookBean> searchBySubject(String subject);

	
	public List<BookBean> searchByPubDate(Date publicationDate);


	public List<BookBean> getAllBooks();
	
	public int getTotalNumBooks();

}
