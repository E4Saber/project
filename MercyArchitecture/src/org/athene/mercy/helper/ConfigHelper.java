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
	 * 获取JDBC驱动
	 * @return
	 */
	public static String getJdbcDriver() {
		return PropsUtil.getString(configProps, Constant.JDBC_DRIVER);
	}
	
	/**
	 * 获取 JDBC URL
	 * @return
	 */
	public static String getJdbcUrl() {
		return PropsUtil.getString(configProps, Constant.JDBC_URL);
	}
	
	/**
	 * 获取JDBC 用户名
	 * @return
	 */
	public static String getJdbcUsername() {
		return PropsUtil.getString(configProps, Constant.JDBC_USERNAME);
	}
	
	/**
	 * 获取JDBC 密码
	 * @return
	 */
	public static String getJdbcPassword() {
		return PropsUtil.getString(configProps, Constant.JDBC_PASSWORD);
	}
	
	/**
	 * 获取应用基础包名
	 * @return
	 */
	public static String getAppBasePackage() {
		return PropsUtil.getString(configProps, Constant.APP_BASE_PACKAGE);
	}
	
	/**
	 * 获取应用 JSP 路径
	 * @return
	 */
	public static String getAppJspPath() {
		return PropsUtil.getString(configProps, Constant.APP_JSP_PATH, "/WEB-INF/view/");
	}
	
	/**
	 * 获取应用静态资源路径
	 * @return
	 */
	public static String getAppAssetPath() {
		return PropsUtil.getString(configProps, Constant.APP_ASSET_PATH, "/asset/");
	}
	
	public static int getAppUploadLimit() {
		return PropsUtil.getInt(configProps, Constant.APP_UPLOAD_LIMIT, 10);
	}
}
