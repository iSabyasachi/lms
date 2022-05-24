package com.lms.accesslibrary.entity.library.book;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.lms.accesslibrary.entity.library.user.User;

@Entity
@Table(name="t_book_item")
public class BookItem {	
	
	private Long id;
    private String trackingNumber;
    private String barcode;
	private Date borrowedDate;
	private Date dueDate;
	private String status;
	private Date checkinDate;
	private BigDecimal price;
	private int active;	
    private User user;
    private int librarianId;
    private Timestamp createdTS;
	private Timestamp updatedTS;
	private Book book;
    
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="tracking_number", nullable = false)
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}	
	
	@Column(name="bar_code", nullable = false)
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	@Column(name = "borrowed_date", nullable = false)
    @DateTimeFormat
	public Date getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	
	@Column(name = "due_date", nullable = false)
    @DateTimeFormat
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	@Column(name = "book_status", nullable = false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "checkin_date", nullable = true)
	@DateTimeFormat
	public Date getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}
	
	@Column(name = "price", nullable = true)
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Column(name = "active", nullable = false)
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	@ManyToOne
    @JoinColumn(name = "account_user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;	
	}
	
	@Column(name = "librarian_id", nullable = false)
	public int getLibrarianId() {
		return librarianId;
	}
	public void setLibrarianId(int librarianId) {
		this.librarianId = librarianId;
	}
	
	@Column(name="date_created", nullable = false)
	public Timestamp getCreatedTS() {
		return createdTS;
	}
	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}
	
	@Column(name="last_updated", nullable = false)
	public Timestamp getUpdatedTS() {
		return updatedTS;
	}
	public void setUpdatedTS(Timestamp updatedTS) {
		this.updatedTS = updatedTS;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	

}
