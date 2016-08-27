package com.annotationssh.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="sid")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer sId;
	
	@Column(name="sname")
	private String sName;
	
	@Column(name="spassword")
	private String sPassword;
	

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public Student(Integer sId, String sName, String sPassword) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sPassword = sPassword;
	}

	public Student(String sName, String sPassword) {
		super();
		this.sName = sName;
		this.sPassword = sPassword;
	}

	public Student(Integer sId) {
		super();
		this.sId = sId;
	}

	public Student() {
		
	}

	
	


}
