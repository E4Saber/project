package org.athene.mercy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.athene.mercy.bean.Data;
import org.athene.mercy.bean.Param;
import org.athene.mercy.bean.View;
import org.athene.mercy.handler.Handler;
import org.athene.mercy.helper.BeanHelper;
import org.athene.mercy.helper.ConfigHelper;
import org.athene.mercy.helper.ControllerHelper;
import org.athene.mercy.helper.HelperLoader;
import org.athene.mercy.helper.RequestHelper;
import org.athene.mercy.helper.ServletHelper;
import org.athene.mercy.helper.UploadHelper;
import org.athene.mercy.util.JsonUtil;
import org.athene.mercy.util.ReflectionUtil;

/**
 * 
 * @author 850030121
 *
 */

@WebServlet(urlPatterns="/*", loadOnStartup=0)
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 8117165137385956422L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 初始化相关 helper类
		HelperLoader.init();
		// 获取ServletContext对象 (用于注册Servlet)
		ServletContext servletContext = config.getServletContext();
		// 注册处理JSP 的Servlet
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
		// 注册处理静态资源的默认Servlet
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
		
		UploadHelper.init(servletContext);
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletHelper.init(request, response);
		try {
			// 获取请求方法与请求路径
			String requestMethod = request.getMethod().toLowerCase();
			String requestPath = request.getPathInfo();
			
			if(requestPath.equals("/favicon.ico")) {
				return;
			}
			
			// 获取Action处理器
			Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
			if(handler!=null) {
				// 获取Controller类以及其bean实例
				Class<?> controllerClass = handler.getControlerClass();
				Object controllerBean = BeanHelper.getBean(controllerClass);
				
				Param param = null;
				if(UploadHelper.isMultipart(request)) {
					param = UploadHelper.createParam(request);
				} else {
					param = RequestHelper.createParam(request);
				}
				
				Object result = null;
				//调用Action方法
				Method actionMethod = handler.getActionMethod();
				if(!param.isEmpty()) {
					 result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
				} else {
					 result = ReflectionUtil.invokeMethod(controllerBean, actionMethod);
				}
				
				// 处理Action方法返回值
				if(result instanceof View) {
					// 返回JSP页面
					handleViewRequest((View)result, request, response);
				} else if(result instanceof Data) {
					// 返回JSON数据
					handleDataRequest((Data)result, request, response);
				}
			}
		} finally {
			ServletHelper.destory();
		}
	}


	private void handleViewRequest(View result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		View view = (View)result;
		String path = view.getPath();
		if(path.startsWith("/")) {
			response.sendRedirect(request.getContextPath() + path);
		} else {
			Map<String, Object> model = view.getModel();
			for(Map.Entry<String, Object> entry : model.entrySet()) {
				request.setAttribute(entry.getKey(), entry.getValue());
			}
			request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request, response);
		}
	}
	
	private void handleDataRequest(Data result, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Data data = (Data)result;
		Object model = data.getModel();
		if(model!=null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			String json = JsonUtil.toJson(model);
			writer.write(json);
			writer.flush();
			writer.close();
		}
	}
	
}
