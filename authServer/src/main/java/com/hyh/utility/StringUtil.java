package com.hyh.utility;

public class StringUtil {

	/**
	 * get object's string value
	 * 
	 * @param str object
	 * @return String object's string value
	 */
	public static String toString(Object str) {
		return isEmpty(str) ? "" : String.valueOf(str);
	}

	/**
	 * judge if object is empty
	 * 
	 * @param str object
	 * @return boolean whether content is empty
	 */
	public static boolean isEmpty(Object str) {
		return (str == null || "".equals(str));
	}
}
