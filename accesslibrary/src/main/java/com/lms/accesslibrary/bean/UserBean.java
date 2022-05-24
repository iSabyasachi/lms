package com.lms.accesslibrary.bean;

import java.sql.Timestamp;
import java.util.Date;

public class UserBean {	
	private String name;
	private AddressBean address;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateOfMembership() {
		return dateOfMembership;
	}
	public void setDateOfMembership(Date dateOfMembership) {
		this.dateOfMembership = dateOfMembership;
	}
	public int getBlockUser() {
		return blockUser;
	}
	public void setBlockUser(int blockUser) {
		this.blockUser = blockUser;
	}
	public double getTotalFine() {
		return totalFine;
	}
	public void setTotalFine(double totalFine) {
		this.totalFine = totalFine;
	}
	public double getFinePaid() {
		return finePaid;
	}
	public void setFinePaid(double finePaid) {
		this.finePaid = finePaid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalNumBooksCheckedOut() {
		return totalNumBooksCheckedOut;
	}
	public void setTotalNumBooksCheckedOut(int totalNumBooksCheckedOut) {
		this.totalNumBooksCheckedOut = totalNumBooksCheckedOut;
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
