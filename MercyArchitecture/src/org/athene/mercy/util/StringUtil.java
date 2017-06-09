package org.athene.mercy.util;

import com.mysql.jdbc.StringUtils;


/**
 * ×Ö·û´®¹¤¾ßÀà 
 * @author 850030121
 *
 */
public class StringUtil {
	
	/**
	 * ×Ö·û´®·Ö¸ô·û
	 */
	public static final String SEPARATOR = String.valueOf((char)29);

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str!=null) {
			str=str.trim();
		}
		return StringUtils.isNullOrEmpty(str);
	}
	
	/**
	 * 
	 * @param str
	 * @param splitChar
	 * @return
	 */
	public static String[] splitString(String str, String splitChar) {
		if(str!=null) {
			return str.split(splitChar);
		}
		return null;
	}

}
