package com.alienwar.demo.daoimpl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import com.alienwar.demo.dao.AlienDao;
import com.alienwar.demo.form.AlienForm;

/**
 * 
 * @author XQL
 *	AlienDaoImpl 业务逻辑实现
 */


public class AlienDaoImpl extends HibernateDaoSupport implements AlienDao {

	
	
	/**
	 * @param alienForm 页面的alien对象
	 * @return true 登录成功
	 * 			false 登录失败
	 */
	@Override
	public boolean alienLogin(AlienForm alienForm) {
		// TODO Auto-generated method stub
		getHibernateTemplate();
		
		return true;
	}


}
