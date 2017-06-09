package org.athene.mercy.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.log4j.Logger;


/**
 * ������������������
 * @author 850030121
 *
 */

public class CodecUtil {

	private static final Logger LOGGER = Logger.getLogger(CodecUtil.class);
	
	/**
	 * ��URL����
	 * @param source
	 * @return
	 */
	public static String encodeURL(String source) {
		String target = null;
		try {
			target = URLEncoder.encode(source, "UTF-8");
		} catch(Exception e) {
			LOGGER.error("encode failure", e);
			throw new RuntimeException(e);
		}
		return target;
	}
	
	/**
	 * ��URL����
	 * @param source
	 * @return
	 */
	public static String decodeURL(String source) {
		String target = null;
		try {
			target = URLDecoder.decode(source, "UTF-8");
		} catch(Exception e) {
			LOGGER.error("encode failure", e);
			throw new RuntimeException(e);
		}
		return target;
	}
}
