package com.lms.accesslibrary.entity.library.book;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lms.accesslibrary.entity.library.BaseEntity;

@Entity
@Table(name="t_book")
@NamedQuery(name = "getBookByBarcode", query = "select b from Book b where b.barcode = :barcode")
public class Book extends BaseEntity{
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
	private Set<BookItem> bookItems;
	private String status;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="isbn", nullable = false)
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	@Column(name="title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="subject", nullable = true)
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Column(name="publisher", nullable = true)
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Column(name="book_language", nullable = true)
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Column(name="number_of_pages", nullable = true)
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	@Column(name="author", nullable = true)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name="bar_code", nullable = false)
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	@Column(name="type", nullable = false)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="publication_date", nullable = true)
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	@Column(name="description", nullable = false)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="genre", nullable = true)
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Column(name="is_reference_only", nullable = false)
	public String getIsReferenceOnly() {
		return isReferenceOnly;
	}
	public void setIsReferenceOnly(String isReferenceOnly) {
		this.isReferenceOnly = isReferenceOnly;
	}
	
	@Column(name="active", nullable = false)
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	@Column(name="units_in_lms", nullable = false)
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	
	@Column(name="rack_num", nullable = false)
	public String getRackNum() {
		return rackNum;
	}
	public void setRackNum(String rackNum) {
		this.rackNum = rackNum;
	}
	@OneToMany(mappedBy="book", cascade = CascadeType.ALL)
	public Set<BookItem> getBookItems() {
		return bookItems;
	}
	public void setBookItems(Set<BookItem> bookItems) {
		this.bookItems = bookItems;
	}
	
	@Column(name="status", nullable = false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
