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
		// 将目标类向上转型为目标接口 ("接口动态实现")
		EnhancedInterfaceForIEA enhanced = (EnhancedInterfaceForIEA)proxyFactory.getProxy();
		enhanced.enhancedInterfaceForIEA();
	}
	
	/*
	 * %m   输出代码中指定的消息  
		%p   输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL   
		%r   输出自应用启动到输出该log信息耗费的毫秒数   
		%c   输出所属的类目，通常就是所在类的全名   
		%t   输出产生该日志事件的线程名   
		%n   输出一个回车换行符，Windows平台为“/r/n”，Unix平台为“/n”   
		%d   输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy-MM-dd HH\:mm\:ss}，输出类似:2015-12-09 22:05:36    
		%l   输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。举例：TestLog4j:16   
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
