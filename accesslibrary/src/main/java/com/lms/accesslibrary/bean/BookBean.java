package com.lms.accesslibrary.bean;

import java.sql.Timestamp;
import java.util.Date;

public class BookBean {
	private Long id;
	private String ISBN;
	private String barcode;	
	private String title;
	private String type;
	private String subject;
	private String publisher;
	private Date publicationDate;
	private String language;
	private int numberOfPages;
	private String author;
	private String description;
	private String genre;
	private String isReferenceOnly;
	private int active;
	private int unit;
	private String rackNum;
	//private Set<BookItem> bookItems;
	private String status;	
	private Timestamp createdTS;
	private Timestamp updatedTS;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getIsReferenceOnly() {
		return isReferenceOnly;
	}
	public void setIsReferenceOnly(String isReferenceOnly) {
		this.isReferenceOnly = isReferenceOnly;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	
	public String getRackNum() {
		return rackNum;
	}
	public void setRackNum(String rackNum) {
		this.rackNum = rackNum;
	}
	/*
	public Set<BookItem> getBookItems() {
		return bookItems;
	}
	public void setBookItems(Set<BookItem> bookItems) {
		this.bookItems = bookItems;
	}*/
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreatedTS() {
		return createdTS;
	}
	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}
	public Timestamp getUpdatedTS() {
		return updatedTS;
	}
	public void setUpdatedTS(Timestamp updatedTS) {
		this.updatedTS = updatedTS;
	}
	
	
}
