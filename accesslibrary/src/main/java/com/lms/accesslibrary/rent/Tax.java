package com.lms.accesslibrary.rent;

import com.lms.accesslibrary.constant.Constants;

public class Tax {
	
	private double salesTax = 0.0;
	private double importTax = 0.0;
	public void calculate(boolean isTaxable, boolean isImported, double price) {
		if(isTaxable) {
			salesTax = price * Constants.SALES_TAX;
		}
		
		if(isImported) {
			importTax = price * Constants.IMPORT_TAX;
		}
	}

	public double getTotalUnitTax() {
		return this.salesTax + this.importTax;
	}

}
