package com.annotationssh.dao;

import org.springframework.stereotype.Repository;

import com.annotationssh.beans.Student;

/**
 * 
 * @author Administrator
 *
 */

public interface UsersDao {
	
	public void addUsers(Student student);
	

}
