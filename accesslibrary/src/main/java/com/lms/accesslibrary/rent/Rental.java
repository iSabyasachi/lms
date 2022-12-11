package com.lms.accesslibrary.rent;

import java.util.Iterator;

import com.lms.accesslibrary.exception.ItemException;

public class Rental {
	/*
	public static void main(String[] args) throws ItemException{
		process();
	}*/

	public void process() throws ItemException{
		//Renting Basket using Builder pattern
		ItemBuilder builder = new RentingBasketBuilder();
		
		//Build Basket of items using Builder Pattern
		builder.buildBasket(Item.TYPE_BOOK, "Java - First Reference", 1, 10.00, 2);
		builder.buildBasket(Item.TYPE_NOTE, "System design", 1, 2.00, 4);
		builder.buildBasket(Item.TYPE_MAGAZINE, "Science Affair", 1, 20.00, 5);
		builder.buildBasket(Item.TYPE_NEWSPAPER, "New York Times", 1, 2.00, 2);
		builder.buildBasket(Item.TYPE_CD, "CD - Omaha", 1, 15.00, 2);
		
		//let's print prices and taxes of this built basket
		double totalTax = builder.calculateTotalTax();
		builder.printExtendedTaxedPrice();
		System.out.println("Sales taxes: "+totalTax);
		System.out.println("Grand Total: "+builder.calculateTotalTax());
		
		System.out.println("After adding an imported CD to the basket");
		builder.buildBasket(Item.TYPE_CD_IMPORTED, "CD - Omaha", 1, 15.00, 2);
		totalTax = builder.calculateTotalTax();
		builder.printExtendedTaxedPrice();
		System.out.println("Sales taxes: "+totalTax);
		System.out.println("Grand Total: "+builder.calculateTotalTax());
		
		System.out.println("--------------------------------------------");
		
		boolean resultStartsWithCD = false;
		CheckStrategy cs = null;
		
		cs = new StartsWithCD();
		CountDecorator cd = new CountDecorator(cs);
		for(Iterator<Item> itr = builder.getIterator(); itr.hasNext() ; itr.next()) {
			Item item = itr.next();
			resultStartsWithCD = cd.check(item.getDescription());
			System.out.println("\n" + item.getDescription() + " ---> " + resultStartsWithCD);
		}
		System.out.println("No of descriptions starts with CD -->" + cd.count());
		
		boolean resultLongerThan15 = false;
		cs = new LongerThan15();
		cd = new CountDecorator(cs);
		for(Iterator<Item> itr = builder.getIterator(); itr.hasNext() ; itr.next()) {
			Item item = itr.next();
			resultLongerThan15 = cd.check(item.getDescription());
			System.out.println("\n" + item.getDescription() + " ---> " + resultLongerThan15);
		}
		System.out.println("No of descriptions Longer Than 15 -->" + cd.count());
		
	}
}
