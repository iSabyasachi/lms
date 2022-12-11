package com.lms.accesslibrary.rent;

import com.lms.accesslibrary.constant.Constants;
import com.lms.accesslibrary.exception.ItemException;

public abstract class Materials implements Item{
	//define attributes
	private String description;
	private int qty;
	private double price;
	private int days;
	private Tax tax = new Tax();
	
	public Materials(String description, int qty, double price, int days){
		this.description = description;
		this.qty = qty;
		this.price = price;
		this.days = days;
	}
	
	protected abstract boolean isTaxed();
	protected abstract boolean isImported();
	
	@Override
	public double getExtendedTax(){
		tax.calculate(isTaxed(), isImported(), price);
		return this.tax.getTotalUnitTax() * qty;
	};
	public double getExtendedTaxPrice() throws ItemException{
		if(tax == null) throw new ItemException("Tax should be calculated first!!!"); 
		
		return qty * this.tax.getTotalUnitTax() * price * (days * Constants.RENT_PRICE_PER_DAY);//Per Day 50 cents for rental
	} 
	
	public String getDescription() {
		return description;
	};
	
	public String toString() {
		return qty + " " + description + " : ";
	}
}
