package org.athene.mercy.proxy;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * ÇÐÃæ´úÀí
 * @author 850030121
 *
 */

public abstract class AspectProxy implements Proxy {
	
	private static final Logger LOGGER = Logger.getLogger(AspectProxy.class);

	@Override
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		Object result = null;
		Class<?> cls = proxyChain.getTargetClass();
		Method method = proxyChain.getTargetMethod();
		Object[] params = proxyChain.getMethodParams();
		
		begin();
		try {
			if(intercept(cls, method, params)) {
				before(cls, method, params);
				result = proxyChain.doProxyChain();
				after(cls, method, params);
			} else {
				result = proxyChain.doProxyChain();
			}
		} catch(Exception e) {
			LOGGER.error("proxy fialure", e);
			error(cls, method, params, e);
			throw e;
		} finally {
			end();
		}
		
		return result;
	}
	
	public void begin() {}
	
	public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable {
		return true;
	}
	
	public void before(Class<?> cls, Method method, Object[] params) throws Throwable {}
	
	public void after(Class<?> cls, Method method, Object[] params) throws Throwable {}
	
	public void error(Class<?> cls, Method method, Object[] params, Exception e) throws Throwable {}
	
	public void end() throws Throwable {}

}
