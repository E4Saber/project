package org.athene.mercy.util;


import org.apache.log4j.Logger;

import com.google.gson.Gson;


/**
 * 
 * @author 850030121
 *
 */
public class JsonUtil {

	private static final Logger LOGGER = Logger.getLogger(JsonUtil.class);
	private static final Gson gson = new Gson();
	
	/**
	 * 将POJO转为JSON
	 * @param obj
	 * @return
	 */
	public static <T> String toJson(T obj) {
		String json = null;
		try {
			json = gson.toJson(obj);
		} catch(Exception e) {
			LOGGER.error("convert POJO to JSON failure", e);
			throw new RuntimeException(e);
		}
		return json;
	}
	
	/**
	 * 将JSON转为POJO
	 * @param json
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> type) {
		T pojo = null;
		try {
			pojo = gson.fromJson(json, type);
		} catch(Exception e) {
			LOGGER.error("convert JSON to POJO failure", e);
			throw new RuntimeException(e);
		}
		return pojo;
	}
}
