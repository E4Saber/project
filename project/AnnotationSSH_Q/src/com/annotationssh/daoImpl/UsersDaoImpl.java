package com.annotationssh.daoImpl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.annotationssh.beans.Student;
import com.annotationssh.dao.UsersDao;

/**
 * 
 * @author Administrator
 *
 */
@Repository("usersDao")
public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {


	@Resource(name = "sessionFactory")  
    public void setSuperSessionFactory(SessionFactory sessionFactory) {  
        super.setSessionFactory(sessionFactory);  
    }  
	
	public void addUsers(Student student) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(student);
		
	}

}
