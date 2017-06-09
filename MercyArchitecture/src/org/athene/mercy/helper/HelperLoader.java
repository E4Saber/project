package org.athene.mercy.helper;

import org.athene.mercy.util.ClassUtil;

/**
 * 
 * @author 850030121
 *
 */

public final class HelperLoader {

	public static void init() {
		Class<?>[] classList = {
				ClassHelper.class,
				BeanHelper.class,
				AopHelper.class,
				IocHelper.class,
				ControllerHelper.class
		};
		for(Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName(), true);
		}
	}
}
