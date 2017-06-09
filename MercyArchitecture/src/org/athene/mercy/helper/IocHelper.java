package org.athene.mercy.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.athene.mercy.annotation.Inject;
import org.athene.mercy.util.CollectionUtil;
import org.athene.mercy.util.ReflectionUtil;

/**
 * “¿¿µ◊¢»Î
 * @author 850030121
 *
 */

public class IocHelper {

	static {
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if(!CollectionUtil.isEmpty(beanMap)) {
			for(Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				Field[] beanFields = beanClass.getDeclaredFields();
				if(beanFields!=null &&beanFields.length>0) {
					for(Field beanField : beanFields) {
						if(beanField.isAnnotationPresent(Inject.class)) {
							Class<?> beanFiledClass = beanField.getType();
							Object beanFieldInstance = beanMap.get(beanFiledClass);
							if(beanFieldInstance!=null) {
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}
	
}
