package com.lms.accesslibrary.utility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.lms.accesslibrary.constant.Constants;

public class DateFormatUtility {
	
	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
	    return java.util.Date.from(dateToConvert.atStartOfDay()
	      .atZone(ZoneId.systemDefault())
	      .toInstant());
	}
	
	public static Date calculateDueDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, Constants.MAX_LENDING_DAYS);
		return c.getTime();
	}
	
	public static Date calculateDueDateForRenewal(Date dueDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(dueDate);
		c.add(Calendar.DATE, Constants.MAX_LENDING_DAYS);
		return c.getTime();
	}
	
	public static Date convertStringToDate(String dateStr) {	
		LocalDate localDate = LocalDate.parse(dateStr);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return date;
	}

}
