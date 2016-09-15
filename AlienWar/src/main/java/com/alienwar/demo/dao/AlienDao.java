package com.alienwar.demo.dao;

import com.alienwar.demo.form.AlienForm;

/**
 * 
 * @author XQL
 *	AlienDao
 */

public interface AlienDao {
	
	/**
	 * @param alien Alien对象
	 * @return true 登录成功  
	 * 		   false 登录失败
	 */
	public boolean alienLogin(AlienForm alienForm);
}
