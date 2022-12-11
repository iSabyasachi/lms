package com.lms.batchlibrarymongo.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class UserDetail {
	private static int instances = 0;
	private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    
	public UserDetail() {
		instances++;
		System.out.println("UserDetail constructor called");
	}
	
	public static int getInstances(){
        return UserDetail.instances;
    }
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
    
    @PostConstruct
    private void postConstruct() {
    	System.out.println("UserDetail Post Constructor called");
    }
    
    @PreDestroy
    private void preDestroy() {
    	System.out.println("UserDetail Pre Destory called");
    }
}
