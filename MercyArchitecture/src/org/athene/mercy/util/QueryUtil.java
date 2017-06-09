package org.athene.mercy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.log4j.Logger;
import org.athene.mercy.constant.Constant;



/**
 * 
 * @author 850030121
 *
 */
public class QueryUtil {
	
	private static final Logger LOGGER = Logger.getLogger(QueryUtil.class);
	private static final QueryRunner queryRunner = new QueryRunner();

	/**
	 * 查询实体列表
	 * @param entityClass
	 * @param sql
	 * @param params
	 * @return
	 */
	public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
		List<T> entityList = null;
		Connection conn = DatabaseUtil.getConnection();
		try {
			entityList = queryRunner.query(conn, sql, new BeanListHandler<T>(entityClass), params);
		} catch (SQLException e) {
			LOGGER.error("query entity list failuer", e);
			throw new RuntimeException(e);
		}
		return entityList;
	}
	
	/**
	 * 查询单个实体
	 * @param entityClass
	 * @param sql
	 * @param params
	 * @return
	 */
	public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
		T entity;
		try {
			entity = queryRunner.query(DatabaseUtil.getConnection(), sql, new BeanHandler<T>(entityClass), params);
		} catch (SQLException e) {
			LOGGER.error("query entity list failuer", e);
			throw new RuntimeException(e);
		}
		return entity;
	}
	
	/**
	 * 返回Map列表
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> queryMapList(String sql, Object... params) {
		List<Map<String, Object>> map;
		try {
			map = queryRunner.query(DatabaseUtil.getConnection(), sql, new MapListHandler(), params);
		} catch (SQLException e) {
			LOGGER.error("query entity list failuer", e);
			throw new RuntimeException(e);
		}
		return map;
	}
	
	/**
	 * 更新
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql, Object...params) {
		int rows = 0;
		try {
			rows = queryRunner.update(DatabaseUtil.getConnection(), sql, params);
		} catch (SQLException e) {
			LOGGER.error("execute update failuer", e);
			throw new RuntimeException(e);
		}
		return rows;
	}
	
	/**
	 * 插入实体
	 * @param entityClass
	 * @param fieldMap
	 * @return
	 */
	public static <T> boolean insertEntity(Class<T> entityClass, Map<String, Object> fieldMap) {
		if(CollectionUtil.isEmpty(fieldMap)) {
			LOGGER.error("cann't insert entity : fieldMap is empty");
			return false;
		}
		String sql = "INSERT INTO " + entityClass.getSimpleName().toLowerCase();
		StringBuilder columns = new StringBuilder("(");
		StringBuilder values = new StringBuilder("(");
		for(String fieldName : fieldMap.keySet()) {
			columns.append(fieldName).append(", ");
			values.append("?, ");
		}
		columns.replace(columns.lastIndexOf(", "), columns.length(), ")");
		values.replace(values.lastIndexOf(", "), values.length(), ")");
		
		sql += columns + " VALUES " + values;
		
		Object[] params = fieldMap.values().toArray();
		return executeUpdate(sql, params) == 1;
	}
	
	/**
	 * 更新实体
	 * @param entityClass
	 * @param id
	 * @param fieldMap
	 * @return
	 */
	public static <T> boolean updateEntity(Class<T> entityClass, long id, Map<String, Object> fieldMap) {
		if(CollectionUtil.isEmpty(fieldMap)) {
			LOGGER.error("cann't update entity : fieldMap is empty");
			return false;
		}
		
		String sql = "UPDATE " + entityClass.getSimpleName();
		StringBuilder columns = new StringBuilder();
		for(String fieldName : fieldMap.keySet()) {
			columns.append(fieldName).append("=?, ");
		}
		sql += columns.substring(0, columns.lastIndexOf(", ")) + " WHERE id=?";
		
		List<Object> paramList = new ArrayList<Object>();
		paramList.addAll(fieldMap.values());
		paramList.add(id);
		Object[] params = paramList.toArray();
		
		return executeUpdate(sql, params) == 1;
	}
	
	/**
	 * 删除实体
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public static <T> boolean deleteEntity(Class<T> entityClass, long id) {
		String sql = "DELETE FROM " + entityClass.getSimpleName() + " WHERE id=?";
		return executeUpdate(sql, id) == 1;
	}
	
	/**
	 * 执行sql文件初始化table表
	 * @param filePath
	 * @throws IOException
	 */
	public static void executeSqlFile(String filePath) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constant.RESOURCE_SQL_PATH + filePath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	//	StringBuilder sqlBuilder = new StringBuilder();
	//  对于过于多的行  对 string 的性能的优化
		String sql = null;
		try {
			while((sql = reader.readLine())!=null) {
				if(!sql.contains(";")) {
					for(sql+=reader.readLine();!sql.contains(";");sql+=reader.readLine());
				}
				System.out.println(sql);
				QueryUtil.executeUpdate(sql);
				sql = null;
			}
			
		} catch (IOException e) {
			LOGGER.error("init table error!");
		}
	}
}
