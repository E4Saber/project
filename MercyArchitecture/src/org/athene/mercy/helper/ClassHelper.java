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
	 * �����༯��(���ڴ�������ص���)
	 */
	private static final Set<Class<?>> classSet;
	
	static {
		String basePackage = ConfigHelper.getAppBasePackage();
		classSet = ClassUtil.getClassSet(basePackage);
	}
	
	/**
	 * ��ȡӦ�ð����µ�������
	 * @return
	 */
	public static Set<Class<?>> getClassSet() {
		return classSet;
	}
	
	/**
	 * ��ȡ Ӧ�ð� ��������Service��
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
	 * ��ȡӦ�ð������е� Controller ��
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
	 * ��ȡӦ�ð���������bean ��(����Service Contorller��)
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet() {
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
	
	/**
	 * ��ȡӦ�ð�����ĳ����(��ӿ�)����������(��ʵ��)
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
	 * ��ȡӦ�ð����´���ĳע���������
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
