package com.lms.accesslibrary.rent;

public class LongerThan15 implements CheckStrategy{
	private static final int LENGTH = 15;
	@Override
	public boolean check(String word) {
		if(word == null)
			return false;
		
		return word.length() > LENGTH;
	}

}
