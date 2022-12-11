package com.lms.accesslibrary.rent;
/*
 * Count the number of items, that satisfies any of the provided strategy.
 * It acts as a wrapper around the object it wants to decorate.So decorator 
 * implements the same interface as the object it decorates.
 * */
public class CountDecorator implements CheckStrategy{
	private CheckStrategy cs = null;
	private int count = 0;
	
	public CountDecorator(CheckStrategy cs) {
		this.cs = cs;
	}
	
	@Override
	public boolean check(String word) {
		boolean isFound = cs.check(word);
		if(isFound)
			this.count++;
		
		return isFound;
	}
	
	public int count() {
		return this.count;
	}
	
	public void reset() {
		this.count = 0;
	}
	
}
