package com.lms.accesslibrary.rent;

import com.lms.accesslibrary.exception.ItemException;

/*
 * Factory Design Pattern:
 * It instantiate a class in a more flexible way than directly calling the constructor.
 * It loosely couples your calling code from the items it creates.
 * 
 * Item Factory is responsible for creating Item Objects like Notes, Books, Magazines, Newspapers, and CDs.
 * */
public abstract class ItemFactory {
	public abstract Item getItem(int itemType, String description, int qty, double price, int days) throws ItemException;
}
