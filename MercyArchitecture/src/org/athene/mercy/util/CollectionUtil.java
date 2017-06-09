package org.athene.mercy.util;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author 850030121
 *
 */

public class CollectionUtil {

	/**
	 * map еп©у
	 * @param map
	 * @return
	 */
	public static <T,E> boolean isEmpty(Map<T,E> map) {
		if(map==null || map.size()==0) {
			return true;
		} 
		return false;
	}
	
	public static <T,E> boolean isEmpty(Collection<T> col) {
		if(col==null || col.size()==0) {
			return true;
		} 
		return false;
	}
}
