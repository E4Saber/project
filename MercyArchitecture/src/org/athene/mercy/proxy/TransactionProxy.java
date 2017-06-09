package org.athene.mercy.proxy;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.athene.mercy.annotation.Transaction;
import org.athene.mercy.util.DatabaseUtil;

/**
 * �������������
 * @author 850030121
 *
 */

public class TransactionProxy implements Proxy {
	
	private static final Logger LOGGER = Logger.getLogger(TransactionProxy.class);

	/**
	 * ��־λ ��֤ͬһ�߳���������Ƶ��߼�ֻ��ִ��һ��
	 */
	private static final ThreadLocal<Boolean> flagHolder = new ThreadLocal<Boolean>() {
		protected Boolean initialValue() {
			return false;
		}
	};
	
	
	@Override
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		Object result = null;
		boolean flg = flagHolder.get();
		Method method = proxyChain.getTargetMethod();
		if(!flg && method.isAnnotationPresent(Transaction.class)) {
			flagHolder.set(true);
			try {
				DatabaseUtil.beginTransaction();
				LOGGER.debug("begin transaction");
				result = proxyChain.doProxyChain();
				DatabaseUtil.commitTransaction();
				LOGGER.debug("commit transaction");
			} catch(Exception e) {
				DatabaseUtil.rollbackTransaction();
				LOGGER.debug("rollback transaction");
				throw e;
			} finally {
				flagHolder.remove();
			}
		} else {
			result = proxyChain.doProxyChain();
		}
		
		return result;
	}

}
