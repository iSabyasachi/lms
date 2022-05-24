package com.lms.accesslibrary.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CheckoutResponse extends Response{	
	private String message;

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
