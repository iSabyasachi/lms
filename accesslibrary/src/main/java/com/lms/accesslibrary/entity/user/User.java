package com.lms.accesslibrary.entity.user;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.lms.accesslibrary.entity.BaseEntity;

@Entity
@Table(name="t_account_user")
public class User extends BaseEntity{
	private long id;
	private String name;
	private Address address;
	private String email;
	private String phone;
	private String type;
	private Date dateOfMembership;	
	private int blockUser;	
	private double totalFine;
	private double finePaid;	
	private String status;
	private int totalNumBooksCheckedOut;
	private Timestamp createdTS;
	private Timestamp updatedTS;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")    
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Column(name="email", nullable = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="phone", nullable = true)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/*Type can be Librarian or Member*/
	@Column(name="user_type", nullable = false)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "membership_date", nullable = true)
    @DateTimeFormat
	public Date getDateOfMembership() {
		return dateOfMembership;
	}
	public void setDateOfMembership(Date dateOfMembership) {
		this.dateOfMembership = dateOfMembership;
	}
	
	@Column(name = "block_user", nullable = false)
	public int getBlockUser() {
		return blockUser;
	}
	public void setBlockUser(int blockUser) {
		this.blockUser = blockUser;
	}
	
	
	@Column(name = "total_fine", nullable = true)
	public double getTotalFine() {
		return totalFine;
	}
	public void setTotalFine(double totalFine) {
		this.totalFine = totalFine;
	}
	
	@Column(name = "fine_paid", nullable = true)
	public double getFinePaid() {
		return finePaid;
	}
	public void setFinePaid(double finePaid) {
		this.finePaid = finePaid;
	}
	
	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "num_books_checked_out", nullable = false)
	public int getTotalNumBooksCheckedOut() {
		return totalNumBooksCheckedOut;
	}
	public void setTotalNumBooksCheckedOut(int totalNumBooksCheckedOut) {
		this.totalNumBooksCheckedOut = totalNumBooksCheckedOut;
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
	
}
