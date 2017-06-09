package org.athene.mercy.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.athene.mercy.annotation.Action;
import org.athene.mercy.handler.Handler;
import org.athene.mercy.handler.Request;


/**
 * 
 * @author 850030121
 *
 */

public class ControllerHelper {

	/**
	 * 用于存放请求与处理器的映射关系
	 */
	private static final Map<Request, Handler> actionMap = new HashMap<Request, Handler>();
	
	static {
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if(controllerClassSet!=null) {
			for(Class<?> controllerClass : controllerClassSet) {
				Method[] methods = controllerClass.getDeclaredMethods();
				if(methods!=null) {
					for(Method method : methods) {
						if(method.isAnnotationPresent(Action.class)) {
							Action action = method.getAnnotation(Action.class);
							String mapping = action.value();
							//验证URL映射规则
							if(mapping.matches("\\w+:/\\w*")) {
								String[] array = mapping.split(":");
								if(array.length==2) {
									String requestMethod = array[0];
									String requestPath = array[1];
									Request reqeust = new Request(requestMethod, requestPath);
									Handler handler = new Handler(controllerClass, method);
									actionMap.put(reqeust, handler);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 获取 Hanlder
	 * @param requestMethod
	 * @param requestPath
	 * @return
	 */
	public static Handler getHandler(String requestMethod, String requestPath) {
		Request reqeust = new Request(requestMethod, requestPath);
		return actionMap.get(reqeust);
	}
}
