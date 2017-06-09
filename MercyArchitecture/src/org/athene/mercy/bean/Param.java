package org.athene.mercy.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.athene.mercy.util.CastUtil;
import org.athene.mercy.util.CollectionUtil;
import org.athene.mercy.util.StringUtil;

/**
 * 
 * @author 850030121
 *
 */

public class Param {

	private List<FormParam> formParamList;
	private List<FileParam> fileParamList;
	
	public Param(List<FormParam> formParamList) {
		this.formParamList = formParamList;
	}

	public Param(List<FormParam> formParamList, List<FileParam> fileParamList) {
		this.formParamList = formParamList;
		this.fileParamList = fileParamList;
	}
	
	/**
	 * 获取请求参数映射
	 * @return
	 */
	public Map<String, Object> getFieldMap() {
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		if(!CollectionUtil.isEmpty(formParamList)) {
			for(FormParam fp : formParamList) {
				String fieldName = fp.getFieldName();
				Object fieldValue = fp.getFieldValue();
				if(fieldMap.containsKey(fieldName)) {
					fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
				}
				fieldMap.put(fieldName, fieldValue);
			}
		}
		return fieldMap;
	}
	
	/**
	 * 获取上传文件映射
	 * @return
	 */
	public Map<String, List<FileParam>> getFileMap() {
		Map<String, List<FileParam>> fileMap = new HashMap<String, List<FileParam>>();
		if(!CollectionUtil.isEmpty(fileParamList)) {
			for(FileParam fp : fileParamList) {
				String filedName = fp.getFiledName();
				List<FileParam> fpList = null;
				if(fileMap.containsKey(filedName)) {
					fpList = fileMap.get(filedName);
				} else {
					fpList = new ArrayList<FileParam>();
				}
				fpList.add(fp);
				fileMap.put(filedName, fpList);
			}
		}
		return fileMap;
	}
	
	/**
	 * 获取所有上传文件
	 * @return
	 */
	public List<FileParam> getFileList(String fieldName) {
		return getFileMap().get(fieldName);
	}
	
	/**
	 * 获取唯一上传文件
	 * @param fieldName
	 * @return
	 */
	public FileParam getFile(String fieldName) {
		List<FileParam> fpList = getFileList(fieldName);
		if(!CollectionUtil.isEmpty(fpList) && fpList.size()==1) {
			return fpList.get(0);
		}
		return null;
	}
	
	/**
	 * 验证参数是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return CollectionUtil.isEmpty(formParamList) && CollectionUtil.isEmpty(fileParamList);
	}
	
	/**
	 * 根据参数名返回字符串类型的参数
	 * @param paramName
	 * @return
	 */
	public String getString(String paramName) {
		return CastUtil.castString(getFieldMap().get(paramName));
	}
	
	/**
	 * 根据参数名返回long类型的参数
	 * @param paramName
	 * @return
	 */
	public long getLong(String paramName) {
		return CastUtil.castLong(getFieldMap().get(paramName));
	}
	
	/**
	 * 根据参数名返回int类型的参数
	 * @param paramName
	 * @return
	 */
	public int getInt(String paramName) {
		return CastUtil.castInt(getFieldMap().get(paramName));
	}
	
	/**
	 * 根据参数名返回boolean类型的参数
	 * @param paramName
	 * @return
	 */
	public boolean getBoolean(String paramName) {
		return CastUtil.castBoolean(getFieldMap().get(paramName));
	}
}
