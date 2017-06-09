package org.athene.mercy.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * »·ÈÆÔöÇ¿
 * @author 850030121
 *
 */

public class MercyAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		before();
		Object result = invocation.proceed();
		after();
		return result;
	}
	
	private void before() {
		System.out.println("Before Advice.........");
	}
	
	private void after() {
		System.out.println("After Advice..........");
	}

}
