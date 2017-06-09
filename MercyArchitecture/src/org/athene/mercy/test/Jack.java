package org.athene.mercy.test;

/**
 * 
 * @author 850030121
 *
 */

public class Jack implements People {

	public void sayHello() {
		System.out.println("I am Jack..");
		
		throw new RuntimeException("Error");
	}
}
