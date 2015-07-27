package org.flickr.util;

public class StringUtil {

	public static String fillTagSpace(String tag) { 

		String temp = tag.trim();
		String space = " ";
		String replace = "%20";

		temp = temp.replace(space, replace);

		return temp;
	}

	public static String fillTagComma(String tag) { 

		String temp = tag.trim();
		String comma = ",";
		String replace = "%2C";

		temp = temp.replace(comma, replace);

		return temp;
	}
}
