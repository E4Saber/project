package org.athene.mercy.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.athene.mercy.bean.FileParam;
import org.athene.mercy.bean.FormParam;
import org.athene.mercy.bean.Param;
import org.athene.mercy.util.CollectionUtil;
import org.athene.mercy.util.FileUtil;
import org.athene.mercy.util.StreamUtil;
import org.athene.mercy.util.StringUtil;

/**
 * 文件上传助手
 * @author 850030121
 *
 */

public class UploadHelper {

	private static final Logger LOGGER = Logger.getLogger(UploadHelper.class);
	
	private static ServletFileUpload servletFileUpload;
	
	public static void init(ServletContext servletContext) {
		File repository = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
		servletFileUpload = new ServletFileUpload(new DiskFileItemFactory(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD, repository));
		int uploadLimit = ConfigHelper.getAppUploadLimit();
		if(uploadLimit!=0) {
			servletFileUpload.setFileSizeMax(uploadLimit*1024*1024);
		}
	}
	
	/**
	 * 判断请求是否为 multipart 类型
	 * @param request
	 * @return
	 */
	public static boolean isMultipart(HttpServletRequest request) {
		return ServletFileUpload.isMultipartContent(request);
	}
	
	/**
	 * 创建请求对象
	 * @param reqeust
	 * @return
	 * @throws IOException 
	 */
	public static Param createParam(HttpServletRequest request) throws IOException {
		List<FormParam> formParamList = new ArrayList<FormParam>();
		List<FileParam> fileParamList = new ArrayList<FileParam>();
		try {
			Map<String, List<FileItem>> fileItemListMap = servletFileUpload.parseParameterMap(request);
			if(!CollectionUtil.isEmpty(fileItemListMap)) {
				for(Map.Entry<String, List<FileItem>> entry : fileItemListMap.entrySet()) {
					String fieldName = entry.getKey();
					List<FileItem> fiList = entry.getValue();
					if(!CollectionUtil.isEmpty(fiList)) {
						for(FileItem fileItem : fiList) {
							if(fileItem.isFormField()) {
								String fieldValue = fileItem.getString("UTF-8");
								formParamList.add(new FormParam(fieldName, fieldValue));
							} else {
								String fileName = FileUtil.getRealFileName(new String(fileItem.getName().getBytes(), "UTF-8"));
								if(!StringUtil.isEmpty(fileName)) {
									long fileSize = fileItem.getSize();
									String contentType = fileItem.getContentType();
									InputStream inputStream = fileItem.getInputStream();
									fileParamList.add(new FileParam(fieldName, fileName, fileSize, contentType, inputStream));
								}
							}
						}
					}
				}
			}
		} catch(FileUploadException e) {
			LOGGER.error("create param failure", e);
			throw new RuntimeException(e);
		}
		return new Param(formParamList, fileParamList);
	}
	
	/**
	 * 上传文件
	 * @param basePath
	 * @param fileParam
	 */
	public static void uploadFile(String basePath, FileParam fileParam) {
		try {
			if(fileParam!=null) {
				String filePath = basePath + fileParam.getFileName();
				FileUtil.createFile(filePath);
				InputStream inputStream = new BufferedInputStream(fileParam.getInputStream());
				OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
				StreamUtil.copyStream(inputStream, outputStream);
			}
		} catch(Exception e) {
			LOGGER.error("upload file failure", e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 批量上传文件
	 * @param basePath
	 * @param fileParamList
	 */
	public static void uploadFile(String basePath, List<FileParam> fileParamList) {
		try {
			if(!CollectionUtil.isEmpty(fileParamList)) {
				for(FileParam fp : fileParamList) {
					uploadFile(basePath, fp);
				}
			}
		} catch(Exception e) {
			LOGGER.error("upload file failure", e);
			throw new RuntimeException(e);
		}
	}
}
