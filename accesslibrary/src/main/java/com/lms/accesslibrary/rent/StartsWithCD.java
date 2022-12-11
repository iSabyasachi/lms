package com.lms.accesslibrary.rent;

public class StartsWithCD implements CheckStrategy{
	private static final String STARTS_WITH = "cd";
	@Override
	public boolean check(String word) {
		if(word == null || word.length() == 0)
			return false;
		word = word.toLowerCase();
		return word.startsWith(STARTS_WITH);
	}

}
