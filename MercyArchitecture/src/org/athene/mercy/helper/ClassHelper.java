package org.athene.mercy.helper;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.athene.mercy.annotation.Controller;
import org.athene.mercy.annotation.Service;
import org.athene.mercy.util.ClassUtil;

/**
 * 
 * @author 850030121
 *
 */

public class ClassHelper {

	/**
	 * 定义类集合(用于存放所加载的类)
	 */
	private static final Set<Class<?>> classSet;
	
	static {
		String basePackage = ConfigHelper.getAppBasePackage();
		classSet = ClassUtil.getClassSet(basePackage);
	}
	
	/**
	 * 获取应用包名下的所有类
	 * @return
	 */
	public static Set<Class<?>> getClassSet() {
		return classSet;
	}
	
	/**
	 * 获取 应用包 名下所有Service类
	 * @return
	 */
	public static Set<Class<?>> getServiceClassSet() {
		Set<Class<?>> cSet = new HashSet<Class<?>>();
		for(Class<?> cls : classSet) {
			if(cls.isAnnotationPresent(Service.class)) {
				cSet.add(cls);
			}
		}
		return cSet;
	}
	
	/**
	 * 获取应用包下所有的 Controller 类
	 * @return
	 */
	public static Set<Class<?>> getControllerClassSet() {
		Set<Class<?>> cSet = new HashSet<Class<?>>();
		for(Class<?> cls : classSet) {
			if(cls.isAnnotationPresent(Controller.class)) {
				cSet.add(cls);
			}
		}
		return cSet;
	}
	
	/**
	 * 获取应用包名下所有bean 类(包括Service Contorller等)
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet() {
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
	
	/**
	 * 获取应用包名下某父类(或接口)的所有子类(或实现)
	 * @param superClass
	 * @return
	 */
	public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
		Set<Class<?>> cSet = new HashSet<Class<?>>();
		for(Class<?> cls : classSet) {
			if(superClass.isAssignableFrom(cls)&&!superClass.equals(cls)) {
				cSet.add(cls);
			}
		}
		return cSet;
	}
	
	/**
	 * 获取应用包名下带有某注解的所有类
	 * @param annotationClass
	 * @return
	 */
	public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
		Set<Class<?>> cSet = new HashSet<Class<?>>();
		for(Class<?> cls : classSet) {
			if(cls.isAnnotationPresent(annotationClass)) {
				cSet.add(cls);
			}
		}
		return cSet;
	}
	
}
