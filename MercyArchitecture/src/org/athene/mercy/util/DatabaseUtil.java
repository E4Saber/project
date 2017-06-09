package org.athene.mercy.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;


/**
 * 数据库连接工具类
 * @author 850030121
 *
 */
public class DatabaseUtil {

	private static final Logger LOGGER = Logger.getLogger(DatabaseUtil.class);
	
	private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	private static final BasicDataSource basicDataSource;
	
	private static final String driver;
	private static final String url;
	private static final String username;
	private static final String password;
	
	static {
		Properties conf = PropsUtil.loadProps("config.properties");
		driver = conf.getProperty("jdbc.driver");
		url = conf.getProperty("jdbc.url");
		username = conf.getProperty("jdbc.username");
		password = conf.getProperty("jdbc.password");
		
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			LOGGER.error("cann't load jdbc driver", e);
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = threadLocal.get();
		try {
			if(conn==null) {
				conn = basicDataSource.getConnection();
			}
		} catch (SQLException e) {
			LOGGER.error("get connection failure", e);
		} finally {
			threadLocal.set(conn);
		}
		return conn;
	}
	
	/**
	 * 开启事务
	 */
	public static void beginTransaction() {
		Connection conn = getConnection();
		if(conn!=null) {
			try {
				conn.setAutoCommit(false);
			} catch(SQLException e) {
				LOGGER.error("begin transaction failure", e);
			} finally {
				threadLocal.set(conn);
			}
		}
	}
	
	/**
	 * 提交事务
	 */
	public static void commitTransaction() {
		Connection conn = getConnection();
		if(conn!=null) {
			try {
				conn.commit();
				conn.close();
			} catch(SQLException e) {
				LOGGER.error("commit transaction failure", e);
			} finally {
				threadLocal.remove();
			}
		}
	}
	
	/**
	 * 事务回滚
	 */
	public static void rollbackTransaction() {
		Connection conn = getConnection();
		if(conn!=null) {
			try {
				conn.rollback();
				conn.close();
			} catch(SQLException e) {
				LOGGER.error("rollback transaction failure", e);
			} finally {
				threadLocal.remove();
			}
		}
	}
	
}
