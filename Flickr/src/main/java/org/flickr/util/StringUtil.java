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

	public static String replaceAtRateOf(String userId) { 

		String temp = userId.trim();
		String at_rate_of = "@";
		String replace = "%40";

		temp = temp.replace(at_rate_of, replace);

		return temp;
	}

	public static String replaceMethodInURL(String url,String method) { 
		
		String temp = url;
		int start_index = url.indexOf("?method=");
		int end_index = -1; 
		String base_url = "";
		String suffix_url = ""; 

		if (start_index != -1) { 

			end_index = url.indexOf('=', start_index+1);  
			
			if (end_index != -1) {
				start_index = url.indexOf('&', end_index+1);
			}
		}

		base_url = url.substring(0, end_index+1);
		suffix_url = url.substring(start_index);
		
		temp = base_url + method.trim() + suffix_url;
		System.out.println(temp);
		return temp;
	}
}
