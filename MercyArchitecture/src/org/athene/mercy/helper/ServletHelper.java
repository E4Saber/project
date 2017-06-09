package org.athene.mercy.helper;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet 助手类
 * @author 850030121
 *
 */
public class ServletHelper {

	private static final Logger LOGGER = Logger.getLogger(ServletHelper.class);
	
	/**
	 * 使每个线程独自拥有一份ServletHelper实例
	 */
	private static final ThreadLocal<ServletHelper> servletHelperHolder = new ThreadLocal<ServletHelper>();
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ServletHelper(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	/**
	 * 初始化
	 */
	public static void init(HttpServletRequest request, HttpServletResponse response) {
		servletHelperHolder.set(new ServletHelper(request, response));
	}
	
	/**
	 * 销毁
	 */
	public static void destory() {
		servletHelperHolder.remove();
	}
	
	/**
	 * 获取Reqeust对象
	 */
	private static HttpServletRequest getRequest() {
		return servletHelperHolder.get().request;
	}
	
	/**
	 * 获取Response对象
	 */
	private static HttpServletResponse getResponse() {
		return servletHelperHolder.get().response;
	}
	
	/**
	 * 获取Session对象
	 */
	private static HttpSession getSession() {
		return servletHelperHolder.get().request.getSession();
	}
	
	/**
	 * 获取ServletContext对象
	 */
	private static ServletContext getServletContextPs() {
		return servletHelperHolder.get().request.getServletContext();
	}
	
	public static void setReqeustAttribute(String key, Object value) {
		getRequest().setAttribute(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getRequestAttribute(String key) {
		return (T) getRequest().getAttribute(key);
	}
	
	public static void remoteRquestAttribute(String key) {
		getRequest().removeAttribute(key);
	}
	
	/**
	 * 发送重定向响应
	 */
	public static void sendRedirect(String location) {
		try {
			getResponse().sendRedirect(getRequest().getContextPath() + location);
		} catch(IOException e) {
			LOGGER.error("redirect failure", e);
		}
	}
	
	public static void setSessionAttribute(String key, Object value) {
		getSession().setAttribute(key, value);
	}
	
	public static void getSessionAttribute(String key) {
		getSession().getAttribute(key);
	}
	
	public static void removeSessionAttribute(String key) {
		getSession().removeAttribute(key);
	}
	
	/**
	 * 使session失效
	 */
	public static void invalidateSession() {
		getRequest().getSession().invalidate();
	}
	
	/**
	 * 获取ServletContext
	 * @return
	 */
	public static ServletContext getServletContext() {
		return getServletContextPs();
	}
}
