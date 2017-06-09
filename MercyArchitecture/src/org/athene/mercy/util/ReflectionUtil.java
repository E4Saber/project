package org.athene.mercy.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * ���乤����
 * @author 850030121
 *
 */

public class ReflectionUtil {

	private static final Logger LOGGER = Logger.getLogger(ReflectionUtil.class);
	
	/**
	 * ����ʵ��
	 * @param cls
	 * @return
	 */
	public static Object newInstance(Class<?> cls) {
		Object instance = null;
		try {
			instance = cls.newInstance();
		} catch (Exception e) {
			LOGGER.error("new instance failure", e);
			throw new RuntimeException(e);
		} 
		return instance;
	}
	
	/**
	 * ���÷���
	 * @param obj
	 * @param method
	 * @param args
	 * @return
	 */
	public static Object invokeMethod(Object obj, Method method, Object...args) {
		Object result = null;
		method.setAccessible(true);
		try {
			result = method.invoke(obj, args);
		} catch (Exception e) {
			LOGGER.error("invoke mevoke failure", e);
			throw new RuntimeException(e);
		}
		return result;
	}
	
	/**
	 * ���ó�Ա������ֵ
	 * @param obj
	 * @param field
	 * @param value
	 */
	public static void setField(Object obj, Field field, Object value) {
		field.setAccessible(true);
		try {
			field.set(obj, value);
		} catch (Exception e) {
			LOGGER.error("set field failure", e);
			throw new RuntimeException(e);
		}
	}
	
}
