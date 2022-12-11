package com.lms.batchlibrarymongo.domain;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book {
	
    @Id
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
	private String status;	
	@CreatedDate
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime lastModifieDate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getLastModifieDate() {
		return lastModifieDate;
	}
	public void setLastModifieDate(LocalDateTime lastModifieDate) {
		this.lastModifieDate = lastModifieDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", ISBN=" + ISBN + ", barcode=" + barcode + ", title=" + title + ", type=" + type
				+ ", subject=" + subject + ", publisher=" + publisher + ", publicationDate=" + publicationDate
				+ ", language=" + language + ", numberOfPages=" + numberOfPages + ", author=" + author
				+ ", description=" + description + ", genre=" + genre + ", isReferenceOnly=" + isReferenceOnly
				+ ", active=" + active + ", unit=" + unit + ", rackNum=" + rackNum + ", status=" + status
				+ ", createdDate=" + createdDate + ", lastModifieDate=" + lastModifieDate + "]";
	}
	
	
}
