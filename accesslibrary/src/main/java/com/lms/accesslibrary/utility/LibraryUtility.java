package com.lms.accesslibrary.utility;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

public class LibraryUtility extends BeanUtils{
	
	public static void copyProperties(Object source, Object target){
		BeanUtils.copyProperties(source, target);
	}
	
	public static boolean isEmpty(String input) {
		CharSequence charSequence = input;
		return StringUtils.isEmpty(charSequence);
	}
}
