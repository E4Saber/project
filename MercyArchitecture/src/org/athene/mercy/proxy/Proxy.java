package org.athene.mercy.proxy;

/**
 * 代理接口
 * @author 850030121
 *
 */

public interface Proxy {

	Object doProxy(ProxyChain proxyChain) throws Throwable;
}
