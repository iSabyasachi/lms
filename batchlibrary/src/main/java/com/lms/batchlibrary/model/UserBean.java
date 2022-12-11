package com.lms.batchlibrary.model;

public class UserBean {
	private long id;
	private String name;	
	private String email;
	private String phone;
	private String type;	
	private String dateOfMembership;
	private String status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getDateOfMembership() {
		return dateOfMembership;
	}
	public void setDateOfMembership(String dateOfMembership) {
		this.dateOfMembership = dateOfMembership;
	}	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", type=" + type
				+ ", dateOfMembership=" + dateOfMembership + ", status=" + status + "]";
	}	
	
}
