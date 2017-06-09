package org.athene.mercy.helper;

import java.util.Properties;

import org.athene.mercy.constant.Constant;
import org.athene.mercy.util.PropsUtil;

/**
 * 
 * @author 850030121
 *
 */

public class ConfigHelper {

	private static final Properties configProps = PropsUtil.loadProps(Constant.CONFIG_FILE);
	
	/**
	 * ��ȡJDBC����
	 * @return
	 */
	public static String getJdbcDriver() {
		return PropsUtil.getString(configProps, Constant.JDBC_DRIVER);
	}
	
	/**
	 * ��ȡ JDBC URL
	 * @return
	 */
	public static String getJdbcUrl() {
		return PropsUtil.getString(configProps, Constant.JDBC_URL);
	}
	
	/**
	 * ��ȡJDBC �û���
	 * @return
	 */
	public static String getJdbcUsername() {
		return PropsUtil.getString(configProps, Constant.JDBC_USERNAME);
	}
	
	/**
	 * ��ȡJDBC ����
	 * @return
	 */
	public static String getJdbcPassword() {
		return PropsUtil.getString(configProps, Constant.JDBC_PASSWORD);
	}
	
	/**
	 * ��ȡӦ�û�������
	 * @return
	 */
	public static String getAppBasePackage() {
		return PropsUtil.getString(configProps, Constant.APP_BASE_PACKAGE);
	}
	
	/**
	 * ��ȡӦ�� JSP ·��
	 * @return
	 */
	public static String getAppJspPath() {
		return PropsUtil.getString(configProps, Constant.APP_JSP_PATH, "/WEB-INF/view/");
	}
	
	/**
	 * ��ȡӦ�þ�̬��Դ·��
	 * @return
	 */
	public static String getAppAssetPath() {
		return PropsUtil.getString(configProps, Constant.APP_ASSET_PATH, "/asset/");
	}
	
	public static int getAppUploadLimit() {
		return PropsUtil.getInt(configProps, Constant.APP_UPLOAD_LIMIT, 10);
	}
}
