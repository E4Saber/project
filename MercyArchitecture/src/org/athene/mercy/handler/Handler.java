package org.athene.mercy.handler;

import java.lang.reflect.Method;

/**
 * ·â×°actionÐÅÏ¢
 * @author 850030121
 *
 */

public class Handler {

	private Class<?> controlerClass;
	private Method actionMethod;
	
	public Handler(Class<?> controlerClass, Method actionMethod) {
		super();
		this.controlerClass = controlerClass;
		this.actionMethod = actionMethod;
	}

	public Class<?> getControlerClass() {
		return controlerClass;
	}

	public Method getActionMethod() {
		return actionMethod;
	}
	
}
