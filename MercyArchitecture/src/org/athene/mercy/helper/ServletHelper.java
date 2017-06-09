package org.athene.mercy.helper;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet ������
 * @author 850030121
 *
 */
public class ServletHelper {

	private static final Logger LOGGER = Logger.getLogger(ServletHelper.class);
	
	/**
	 * ʹÿ���̶߳���ӵ��һ��ServletHelperʵ��
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
	 * ��ʼ��
	 */
	public static void init(HttpServletRequest request, HttpServletResponse response) {
		servletHelperHolder.set(new ServletHelper(request, response));
	}
	
	/**
	 * ����
	 */
	public static void destory() {
		servletHelperHolder.remove();
	}
	
	/**
	 * ��ȡReqeust����
	 */
	private static HttpServletRequest getRequest() {
		return servletHelperHolder.get().request;
	}
	
	/**
	 * ��ȡResponse����
	 */
	private static HttpServletResponse getResponse() {
		return servletHelperHolder.get().response;
	}
	
	/**
	 * ��ȡSession����
	 */
	private static HttpSession getSession() {
		return servletHelperHolder.get().request.getSession();
	}
	
	/**
	 * ��ȡServletContext����
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
	 * �����ض�����Ӧ
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
	 * ʹsessionʧЧ
	 */
	public static void invalidateSession() {
		getRequest().getSession().invalidate();
	}
	
	/**
	 * ��ȡServletContext
	 * @return
	 */
	public static ServletContext getServletContext() {
		return getServletContextPs();
	}
}
