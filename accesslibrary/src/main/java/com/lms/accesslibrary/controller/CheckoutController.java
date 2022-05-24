package com.lms.accesslibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.accesslibrary.dto.Checkout;
import com.lms.accesslibrary.dto.CheckoutResponse;
import com.lms.accesslibrary.service.iCheckoutService;

@RestController
@RequestMapping("/access")
public class CheckoutController {
	
	private Logger logger = LoggerFactory.getLogger(CheckoutController.class);
	
	@Autowired
	private iCheckoutService checkoutService;

	public CheckoutController(iCheckoutService checkoutService) {		
		this.checkoutService = checkoutService;
	}
	
	@PostMapping("/checkout")
    public CheckoutResponse checkoutBook(@RequestBody Checkout checkout) {
		logger.info("Checkout Book method in CheckoutController class is invoked.");
		
		CheckoutResponse checkoutResponse = checkoutService.checkoutBookItem(checkout);

        return checkoutResponse;
    }
	
	@PostMapping("/return")
    public CheckoutResponse returnBook(@RequestBody Checkout checkout) {
		logger.info("Return Book method in CheckoutController class is invoked.");
		
		CheckoutResponse checkoutResponse = checkoutService.returnBookItem(checkout);

        return checkoutResponse;
    }
	
	@PostMapping("/renew")
    public CheckoutResponse renewBook(@RequestBody Checkout checkout) {
		logger.info("Renew Book method in CheckoutController class is invoked.");		
		
		CheckoutResponse checkoutResponse = checkoutService.renewBookItem(checkout);

        return checkoutResponse;
    }
	
	@PostMapping("/reserve")
    public CheckoutResponse reserveBook(@RequestBody Checkout checkout) {
		logger.info("Reserve Book method in CheckoutController class is invoked.");		
		
		CheckoutResponse checkoutResponse = checkoutService.reserveBook(checkout);

        return checkoutResponse;
    }
	
	@PostMapping("/payfine")
    public CheckoutResponse payFine(@RequestBody Checkout checkout) {
		logger.info("Pay fine method in CheckoutController class is invoked.");		
		
		CheckoutResponse checkoutResponse = checkoutService.payFine(checkout);

        return checkoutResponse;
    }
	
	@GetMapping("/getfine")
    public CheckoutResponse getFine(@RequestBody Checkout checkout) {
		logger.info("Get Fine method in CheckoutController class is invoked.");		
		
		CheckoutResponse checkoutResponse = checkoutService.getFine(checkout);

        return checkoutResponse;
    }
}
