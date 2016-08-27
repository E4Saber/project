package dao;

import java.util.List;

import org.hibernate.HibernateException;

import players.beans.Users;


/**
 * 
 * @author Administrator
 *  �����Dao  
 */
public interface BaseDao {
	
	public void saveObject(Object obj) throws HibernateException;
	public List<Users> findByName();
}
