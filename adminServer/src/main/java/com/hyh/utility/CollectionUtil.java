package com.hyh.utility;

public class CollectionUtil {

	/**
	 * judge if Iterable object has element
	 * 
	 * @param obj Iterable object
	 * @return boolean whether content is empty
	 */
	public static <T> boolean isEmpty(Iterable<T> obj) {
		return (obj == null || (!obj.iterator().hasNext()));
	}

}
