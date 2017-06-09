package org.athene.mercy.test;

import org.apache.log4j.Logger;
import org.athene.mercy.advice.EnhancedInterfaceForIEA;
import org.athene.mercy.advice.MercyIntroduceEnhancedAdvice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 
 * @author 850030121
 *
 */

public class TestFactory {
	
	
	public void init() {
		ProxyFactory proxyFactory = new ProxyFactory();
	//	proxyFactory.setTarget(new Jack());
	//	proxyFactory.addAdvice(new MercyAroundAdvice());
	//	proxyFactory.addAdvice(new MercyThrowAdvice());
//		/People jack = (People)proxyFactory.getProxy();
		// jack.sayHello();
		
		
		proxyFactory.setInterfaces(EnhancedInterfaceForIEA.class);
		proxyFactory.setProxyTargetClass(true);
		proxyFactory.addAdvice(new MercyIntroduceEnhancedAdvice());
		// ��Ŀ��������ת��ΪĿ��ӿ� ("�ӿڶ�̬ʵ��")
		EnhancedInterfaceForIEA enhanced = (EnhancedInterfaceForIEA)proxyFactory.getProxy();
		enhanced.enhancedInterfaceForIEA();
	}
	
	/*
	 * %m   ���������ָ������Ϣ  
		%p   ������ȼ�����DEBUG��INFO��WARN��ERROR��FATAL   
		%r   �����Ӧ�������������log��Ϣ�ķѵĺ�����   
		%c   �����������Ŀ��ͨ�������������ȫ��   
		%t   �����������־�¼����߳���   
		%n   ���һ���س����з���Windowsƽ̨Ϊ��/r/n����Unixƽ̨Ϊ��/n��   
		%d   �����־ʱ�������ڻ�ʱ�䣬Ĭ�ϸ�ʽΪISO8601��Ҳ���������ָ����ʽ�����磺%d{yyy-MM-dd HH\:mm\:ss}���������:2015-12-09 22:05:36    
		%l   �����־�¼��ķ���λ�ã�������Ŀ�����������̣߳��Լ��ڴ����е�������������TestLog4j:16   
	 * */
	
	
	private static Logger logger = Logger.getLogger(TestFactory.class); 
	
	@Test
	public void testlo() {
		for (int i = 0; i < 5; i++) {  
            logger.info("i=" + i);  
        }  
          
        logger.debug("#####logger.debug#####");  
  
        logger.error("#####logger.error#####"); 
	}
	
}
