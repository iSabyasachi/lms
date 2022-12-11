package com.lms.accesslibrary.rent;

import com.lms.accesslibrary.exception.ItemException;
/*
 * Material Factory is responsible for creating Item Objects like Notes, Books, Magazines, Newspapers, and CDs.
 * 
 * Abstract Factories : It is one level of abstraction higher than the factory method pattern because 
 * you have an abstract factory(or factory interface(Ex. createShape()) and have multiple concrete factories.(Ex: createSquare(), createCircle())
 * */
public class MaterialFactory extends ItemFactory{
	/*Protected so that only ItemFactorySelector within this package can instantiate it to provide a
	 * single point of access(i.e singleton)*/
	protected MaterialFactory() {} 
	@Override
	public Item getItem(int itemType, String description, int qty, double price, int days) throws ItemException {
		Item item = null; // Code to interface
		if(itemType == Item.TYPE_NOTE) {
			item = new Book(description, qty, price, days);
		}else if(itemType == Item.TYPE_BOOK) {
			item = new Book(description, qty, price, days);
		}else if(itemType == Item.TYPE_MAGAZINE) {
			item = new Magazine(description, qty, price, days);
		}else if(itemType == Item.TYPE_NEWSPAPER) {
			item = new Newspaper(description, qty, price, days);
		}else if(itemType == Item.TYPE_CD) {
			item = new Newspaper(description, qty, price, days);
		}else if(itemType == Item.TYPE_CD_IMPORTED) {
			item = new Newspaper(description, qty, price, days);
			item.setImported(Boolean.TRUE);
		}else {
			throw new ItemException("Inavlid ItemType=" + itemType);
		}		
		return item; //Return object is referenced by its interface instead of by its implementation
	}

}
