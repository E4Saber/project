package org.athene.mercy.proxy;

/**
 * ����ӿ�
 * @author 850030121
 *
 */

public interface Proxy {

	Object doProxy(ProxyChain proxyChain) throws Throwable;
}
