package com.lms.searchlibrary.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.searchlibrary.bean.BookBean;
import com.lms.searchlibrary.proxy.AccessLibraryProxy;

@Service
public class SearchService implements iSearchService{
	
	@Autowired
	private AccessLibraryProxy accessLibraryProxy;
	
	public List<BookBean> getAllBooks(){
		List<BookBean> bookBeans = accessLibraryProxy.getAllBooks();		
		return bookBeans;
	}
	
	@Override
	public List<BookBean> searchByTitle(String title) {
		List<BookBean> bookBeans = null != this.getAllBooks() && 
				this.getAllBooks().size() > 0 ? 
						this.getAllBooks()
						.stream()
						.filter(d -> d.getTitle().equals(title))
						.collect(Collectors.toList()) : null;
		return bookBeans;
	}

	@Override
	public List<BookBean> searchByAuthor(String author) {
		System.out.println("### this.getAllBooks().size()"+this.getAllBooks().size());
		List<BookBean> bookBeans = null != this.getAllBooks() && 
				this.getAllBooks().size() > 0 ? 
						this.getAllBooks()
						.stream()
						.filter(d -> d.getAuthor().equals(author))
						.collect(Collectors.toList()) : null;
		return bookBeans;
	}

	@Override
	public List<BookBean> searchBySubject(String subject) {		
		List<BookBean> bookBeans = null != this.getAllBooks() && 
				this.getAllBooks().size() > 0 ? 
						this.getAllBooks()
						.stream()
						.filter(d -> d.getSubject().equals(subject))
						.collect(Collectors.toList()) : null;
		return bookBeans;
	}

	@Override
	public List<BookBean> searchByPubDate(Date publicationDate) {		
		List<BookBean> bookBeans = null != this.getAllBooks() && 
				this.getAllBooks().size() > 0 ? 
						this.getAllBooks()
						.stream()
						.filter(d -> d.getPublicationDate().equals(publicationDate))
						.collect(Collectors.toList()) : null;
		return bookBeans;
	}

	@Override
	public int getTotalNumBooks() {
		int totalNumBooks = null != this.getAllBooks() && 
				this.getAllBooks().size() > 0 ? this.getAllBooks().size() : 0;
		return totalNumBooks;
	}
	
	public int findIndex(int[] array, int number) {
		return Arrays.binarySearch(array, number) > 0 ? 1 : -1;
	}
	
	public boolean searchForNumber(int[] array, int numberToSearchFor) {
		if(Arrays.binarySearch(array, numberToSearchFor) > 0) {
			return true;
		}
		return false;
	}
}
