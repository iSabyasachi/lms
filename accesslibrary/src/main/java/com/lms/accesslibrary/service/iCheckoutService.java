package com.lms.accesslibrary.service;

import org.springframework.stereotype.Service;

import com.lms.accesslibrary.dto.Checkout;
import com.lms.accesslibrary.dto.CheckoutResponse;

@Service
public interface ICheckoutService {
	public CheckoutResponse checkoutBookItem(Checkout checkout);
	public CheckoutResponse returnBookItem(Checkout checkout);
	public CheckoutResponse renewBookItem(Checkout checkout);
	public CheckoutResponse payFine(Checkout checkout);
	public CheckoutResponse getFine(Checkout checkout);
	public CheckoutResponse reserveBook(Checkout checkout);
}
