package org.athene.mercy.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * Å×³öÔöÇ¿
 * @author 850030121
 *
 */
public class MercyThrowAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
		System.out.println("------------- Throw Exception -----------------");
		System.out.println("Target Class: " + target.getClass().getName());
		System.out.println("Method Name: " + method.getName());
		System.out.println("Exception Message: " + e.getMessage());
		System.out.println("-----------------------------------------------");
	}
}
