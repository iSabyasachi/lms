package com.lms.accesslibrary.rent;

import com.lms.accesslibrary.exception.ItemException;

public interface Item {
	public static final int TYPE_NOTE = 1;
	public static final int TYPE_BOOK = 2;
	public static final int TYPE_MAGAZINE = 3;
	public static final int TYPE_NEWSPAPER = 4;
	public static final int TYPE_CD = 5;
	public static final int TYPE_CD_IMPORTED = 6;
	
	public double getExtendedTax();
	public double getExtendedTaxPrice() throws ItemException;
	public void setImported(boolean b);
	public String getDescription();
}
