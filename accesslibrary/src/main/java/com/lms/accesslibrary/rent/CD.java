package com.lms.accesslibrary.rent;

public class CD extends Materials{
	private boolean isImported = false;
	private boolean isTaxed = true;
	
	public CD(String description, int qty, double price, int days) {
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