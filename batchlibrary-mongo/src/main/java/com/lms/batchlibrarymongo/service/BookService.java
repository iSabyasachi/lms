package com.lms.batchlibrarymongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.batchlibrarymongo.domain.Book;
import com.lms.batchlibrarymongo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public Book getBook(long id) {
		int[] res = new int[2];
		System.out.println(res[3]);
		return bookRepository.findById(id).get();
	}
}
