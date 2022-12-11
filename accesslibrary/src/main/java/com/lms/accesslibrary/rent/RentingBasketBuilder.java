package com.lms.accesslibrary.rent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lms.accesslibrary.exception.ItemException;
/*Objective is to build instances of other classes*/
public class RentingBasketBuilder implements ItemBuilder{
	private List<Item> listItems = null;
	
	private void addItem(Item item) {
		if(listItems == null) {
			listItems = new ArrayList<>(20);
		}
		listItems.add(item);
	}
	
	@Override
	public void buildBasket(int itemType, String description, int qty, double unit_price, int days)
			throws ItemException {		
		//get the single instance of MaterialFactory using Singleton pattern
		ItemFactory factory = ItemFactorySelector.getItemFactory();
		Item item = factory.getItem(itemType, description, qty, unit_price, days);
		this.addItem(item);
	}

	@Override
	public double calculateTotalTax() throws ItemException {
		if(listItems == null) throw new ItemException("No Items in the Basket!!!");
		
		double totalTax = 0.0;		
		for(Iterator<Item> itr = this.getIterator(); itr.hasNext(); ){
			Item item = itr.next();
			totalTax += item.getExtendedTax();
		}
		return totalTax;
	}

	@Override
	public double calculateTotal() throws ItemException {
		if(listItems == null) throw new ItemException("No Items in the Basket!!!");
		
		double total = 0.0;		
		for(Iterator<Item> itr = this.getIterator(); itr.hasNext(); ){
			Item item = itr.next();
			total += item.getExtendedTaxPrice();
		}
		return total;
	}

	@Override
	public void printExtendedTaxedPrice() throws ItemException {
		
		if(listItems == null) throw new ItemException("No Items in the Basket!!!");
		
		for(Iterator<Item> itr = listItems.iterator(); itr.hasNext(); ){
			Item item = itr.next();
			System.out.println(item +""+item.getExtendedTaxPrice());
		}
	}

	@Override
	public Iterator<Item> getIterator() throws ItemException {
		return listItems.iterator();
	}

}
