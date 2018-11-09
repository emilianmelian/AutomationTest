package com.tools.utils;

import org.apache.commons.lang.StringUtils;

public class StringHelpers {

	public static String cleanZeroLeadingStrings(String no) {
		return StringUtils.stripStart(no,"0");
	}
	
	
	public static String capitalizedFirstLetter(String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
}
