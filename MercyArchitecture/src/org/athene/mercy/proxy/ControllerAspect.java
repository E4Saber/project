package org.athene.mercy.proxy;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.athene.mercy.annotation.Aspect;
import org.athene.mercy.annotation.Controller;


/**
 * 拦截 Controller 所有方法
 * @author 850030121
 *
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

	private static final Logger LOGGER = Logger.getLogger(ControllerAspect.class);

	private long begin = 0l;
	
	@Override
	public void before(Class<?> cls, Method method, Object[] params)
			throws Throwable {
		LOGGER.debug("--------------- begin --------------");
		LOGGER.debug(String.format("class: %s", cls.getName()));
		LOGGER.debug(String.format("method: %s", method.getName()));
		begin = System.currentTimeMillis();
	}

	@Override
	public void after(Class<?> cls, Method method, Object[] params)
			throws Throwable {
		LOGGER.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
		LOGGER.debug("---------------- end ----------------");
	}
	
}
