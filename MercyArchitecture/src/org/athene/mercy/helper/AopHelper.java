package org.athene.mercy.helper;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.athene.mercy.annotation.Aspect;
import org.athene.mercy.annotation.Service;
import org.athene.mercy.proxy.AspectProxy;
import org.athene.mercy.proxy.Proxy;
import org.athene.mercy.proxy.ProxyManager;
import org.athene.mercy.proxy.TransactionProxy;

/**
 * 
 * @author 850030121
 *
 */

public class AopHelper {
	
	private static final Logger LOGGER = Logger.getLogger(AopHelper.class);
	
	static {
		try {
			Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
			Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
			for(Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()) {
				Class<?> targetClass = targetEntry.getKey();
				List<Proxy> proxyList = targetEntry.getValue();
				Object proxy = ProxyManager.createProxy(targetClass, proxyList);
				LOGGER.debug("targetClass" + targetClass + " proxy: " + proxy);
				BeanHelper.setBean(targetClass, proxy);
			}
		} catch(Exception e) {
			LOGGER.error("aop failure", e);
		}
	}
	
	/**
	 * 添加普通的切面代理
	 * @param proxyMap
	 * @throws Exception
	 */
	private static void addAspectProxy(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
		Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
		for(Class<?> cls : proxyClassSet) {
			if(cls.isAnnotationPresent(Aspect.class)) {
				Aspect aspect = cls.getAnnotation(Aspect.class);
				Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
				proxyMap.put(cls, targetClassSet);
			}
		}
	}
	
	/**
	 * 添加事务代理
	 * @param proxyMap
	 * @throws Exception
	 */
	private static void addTransactionProxy(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
		Set<Class<?>> serviceClassSet = ClassHelper.getClassSetByAnnotation(Service.class);
		proxyMap.put(TransactionProxy.class, serviceClassSet);
	}
	

	/**
	 * 获取带有Aspect注解的所有类
	 * @param aspect
	 * @return
	 */
	private static Set<Class<?>> createTargetClassSet(Aspect aspect) {
		Set<Class<?>> targetClassSet = new HashSet<Class<?>>();
		Class<? extends Annotation> annotation = aspect.value();
		if(annotation!=null&&!annotation.equals(Aspect.class)) {
			targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
		}
		return targetClassSet;
	}
	
	/**
	 * 代理类与目标类(切面类)的集合映射关系
	 * @return
	 * @throws Exception
	 */
	private static Map<Class<?>, Set<Class<?>>> createProxyMap() throws Exception {
		Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<Class<?>, Set<Class<?>>>();
		addAspectProxy(proxyMap);
		addTransactionProxy(proxyMap);
		return proxyMap;
	}
	
	/**
	 * 目标类与代理对象列表之间的映射关系
	 * @param proxyMap
	 * @return
	 * @throws Exception
	 */
	private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
		Map<Class<?>, List<Proxy>> targetMap = new HashMap<Class<?>, List<Proxy>>();
		for(Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()) {
			Class<?> proxyClass = proxyEntry.getKey();
			Set<Class<?>> targetClassSet = proxyEntry.getValue();
			for(Class<?> targetClass : targetClassSet) {
				Proxy proxy = (Proxy)proxyClass.newInstance();
				if(targetMap.containsKey(targetClass)) {
					targetMap.get(targetClass).add(proxy);
				} else {
					List<Proxy> proxyList = new ArrayList<Proxy>();
					proxyList.add(proxy);
					targetMap.put(targetClass, proxyList);
				}
			}
		}
		return targetMap;
	} 
}
