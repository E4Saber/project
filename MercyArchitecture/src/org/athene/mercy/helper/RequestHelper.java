package org.athene.mercy.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.athene.mercy.bean.FormParam;
import org.athene.mercy.bean.Param;
import org.athene.mercy.util.CodecUtil;
import org.athene.mercy.util.StreamUtil;
import org.athene.mercy.util.StringUtil;

/**
 * 
 * @author 850030121
 *
 */

public class RequestHelper {

	/**
	 * 创建请求对象
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static Param createParam(HttpServletRequest request) throws IOException {
		List<FormParam> formParamList = new ArrayList<FormParam>();
		formParamList.addAll(parseParameterNames(request));
		formParamList.addAll(parseInputStream(request));
		return new Param(formParamList);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	private static List<FormParam> parseParameterNames(HttpServletRequest request) {
		List<FormParam> formParamList = new ArrayList<FormParam>();
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String fieldName = paramNames.nextElement();
			String[] fieldValues = request.getParameterValues(fieldName);
			if(fieldValues!=null&&fieldValues.length>0) {
				Object fieldValue = null;
				if(fieldValues.length==1) {
					fieldValue = fieldValues[0];
				} else {
					StringBuilder sb = new StringBuilder("");
					for(int i=0;i<fieldValues.length;i++) {
						if(i>0) {
							sb.append(StringUtil.SEPARATOR);
						}
						sb.append(fieldValues[i]);
					}
					fieldValue = sb.toString();
				}
				formParamList.add(new FormParam(fieldName, fieldValue));
			}
		}
		return formParamList;
	}
	
	private static List<FormParam> parseInputStream(HttpServletRequest request) throws IOException {
		List<FormParam> formParamList = new ArrayList<FormParam>();
		String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
		if(!StringUtils.isEmpty(body)) {
			String[] kvs = StringUtil.splitString(body, "&");
			if(kvs!=null&&kvs.length>0) {
				for(String kv : kvs) {
					String[] array = StringUtil.splitString(kv, "=");
					if(array!=null&&array.length==2) {
						String fieldName = array[0];
						String fieldValue = array[1];
						formParamList.add(new FormParam(fieldName, fieldValue));
					}
				}
			}
		}
		return formParamList;
	}
}
