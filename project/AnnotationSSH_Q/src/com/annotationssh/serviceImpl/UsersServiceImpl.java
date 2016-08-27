package com.annotationssh.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.annotationssh.beans.Student;
import com.annotationssh.dao.UsersDao;
import com.annotationssh.service.UsersService;

/**
 * 
 * @author Administrator
 *
 */
@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {

	@Resource(name="usersDao")
	private UsersDao usersDao;
	
	public void addUsers(Student student) {
		// TODO Auto-generated method stub
		usersDao.addUsers(student);
	}

}
