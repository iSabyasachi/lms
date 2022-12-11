package com.lms.accesslibrary.rent;

public class Newspaper extends Materials{
	private boolean isImported = false;
	private boolean isTaxed = false;
	
	public Newspaper(String description, int qty, double price, int days) {
		super(description, qty, price, days);
	}

	@Override
	public void setImported(boolean isImported) {		
		this.isImported = isImported;
	}

	@Override
	protected boolean isTaxed() {		
		return this.isTaxed;
	}

	@Override
	protected boolean isImported() {		
		return this.isImported;
	}

}
