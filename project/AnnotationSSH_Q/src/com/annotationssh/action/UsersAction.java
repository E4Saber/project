package com.annotationssh.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.annotationssh.beans.Student;
import com.annotationssh.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller

public class UsersAction extends ActionSupport {
	
	@Resource(name="usersService")
	private UsersService usersService;
	private Student student;
	
	
	@Action(value="usersAction",results = {
			@Result(name="success",location="/success.jsp"),
			@Result(name="false",location="/error.jsp")})
	public String addUsers(){
		
		student = new Student();
		student.setsId(1);
		student.setsName("xiaoli");
		student.setsPassword("1234");
		
		usersService.addUsers(student);		
		return SUCCESS;
	}

}
