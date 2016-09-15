package com.alienwar.demo.serviceimpl;

import org.springframework.stereotype.Service;
import com.alienwar.demo.form.AlienForm;
import com.alienwar.demo.service.AlienService;


/**
 * 
 * @author XQL
 * AlienServiceImpl  
 */

@Service
public class AlienServiceImpl implements AlienService {
	
	
	/**  AlienDaoImpl的父类引用  **/
//	@Autowired
//	private AlienDaoImpl alienDao;
	

	/**
	 * @param alienForm 页面alien对象
	 * @return true 登录成功
	 * 			false  登录失败
	 */
	@Override
	public boolean alienLogin(AlienForm alienForm) {
		// TODO Auto-generated method stub
		return true;
	}





}
