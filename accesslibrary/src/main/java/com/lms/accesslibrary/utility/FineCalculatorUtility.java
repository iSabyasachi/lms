package com.lms.accesslibrary.utility;

import java.util.Date;

import com.lms.accesslibrary.constant.Constants;

public class FineCalculatorUtility {
	
	public static double calculateFine(Date dueDate) {
		double fineAmount = 0.00;
		Date today = new Date();
		// check if the book has been returned within the due date
		if (today.compareTo(dueDate) > 0) {
			long diff = today.getTime() - dueDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);
			fineAmount = Constants.FINE_PER_DAYS * diffDays;
		}
		return fineAmount;
	}

}
