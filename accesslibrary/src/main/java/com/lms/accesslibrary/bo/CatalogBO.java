package com.lms.accesslibrary.bo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.lms.accesslibrary.entity.book.Book;

public class CatalogBO{

	private HashMap<String, List<Book>> bookTitles;
	private HashMap<String, List<Book>> bookAuthors;
	private HashMap<String, List<Book>> bookSubjects;
	private HashMap<String, List<Book>> bookPublicationDates;

	
	public List<Book> searchByTitle(String query) {
		// return all books containing the string query in their title.
	    return bookTitles.get(query);
	}

	
	public List<Book> searchByAuthor(String query) {
		// return all books containing the string query in their author's name.
	    return bookAuthors.get(query);
	}

	
	public List<Book> searchBySubject(String query) {
		return bookSubjects.get(query);
	}

	
	public List<Book> searchByPubDate(Date query) {
		return bookPublicationDates.get(query);
	}

}
