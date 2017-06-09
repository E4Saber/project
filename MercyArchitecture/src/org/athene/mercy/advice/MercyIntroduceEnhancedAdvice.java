package org.athene.mercy.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * ������ǿ  ʵ���˽ӿڵ���ǿ������
 * @author 850030121
 *
 */

public class MercyIntroduceEnhancedAdvice extends
		DelegatingIntroductionInterceptor implements EnhancedInterfaceForIEA {

	private static final long serialVersionUID = -6116056443597810912L;

	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		return super.invoke(invocation);
	}


	@Override
	public void enhancedInterfaceForIEA() {
		// TODO Auto-generated method stub
		System.out.println("This is MercyIntroduceEnhancedAdvice implements EnhancedInterfaceForIEA");
	}

}
