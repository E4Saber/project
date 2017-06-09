package org.athene.mercy.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.athene.mercy.util.ReflectionUtil;

/**
 * Bean ������
 * @author 850030121
 *
 */

public class BeanHelper {

	private static final Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>();
	
	static {
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for(Class<?> beanClass : beanClassSet) {
			Object obj = ReflectionUtil.newInstance(beanClass);
			beanMap.put(beanClass, obj);
		}
	}
	
	/**
	 * ��ȡ Bean ӳ��
	 * @return
	 */
	public static Map<Class<?>, Object> getBeanMap() {
		return beanMap;
	}
	
	public static void setBean(Class<?> cls, Object obj) {
		beanMap.put(cls, obj);
	}
	
	/**
	 * ��ȡBeanʵ��
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls) {
		if(!beanMap.containsKey(cls)) {
			throw new RuntimeException("cann't get bean by class" + cls);
		}
		return (T)beanMap.get(cls);
	}
}
