package com.lms.accesslibrary.rent;

import java.util.Iterator;

import com.lms.accesslibrary.exception.ItemException;

/*
 * The difference between the builder pattern and the factory pattern is that in builder pattern, the user is given
 * the choice to create the type of object he.she wants but the construction process is the same.
 * But the factory method pattern the factory decides how to create one of the several possible classes based on the data provided to it.
 * */
public interface ItemBuilder {
	public void buildBasket(int itemType, String description, int qty, double unit_price, int days) throws ItemException;
	
	public double calculateTotalTax() throws ItemException;
	public double calculateTotal() throws ItemException;
	public void printExtendedTaxedPrice() throws ItemException;
	public Iterator<Item> getIterator() throws ItemException;
}
