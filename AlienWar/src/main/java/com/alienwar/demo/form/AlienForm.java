package com.alienwar.demo.form;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.alienwar.demo.util.validator.Aliens;

/**
 * 
 * @author XQL
 *	AlienForm 页面对象
 */

public class AlienForm {
	
	@NotNull
	@Size(min=3, max=10, message="{alienNo.size}")
	private String alienNo;
	
	@NotNull
	@Size(min=3, max=10, message="{alienName.size}")
	@Aliens()
	private String alienName;
	
	@NotNull
	@Size(min=3, max=10, message="{alienRace.size}")
	private String alienRace;
	
	
	
	
	public String getAlienNo() {
		return alienNo;
	}
	public void setAlienNo(String alienNo) {
		this.alienNo = alienNo;
	}
	public String getAlienName() {
		return alienName;
	}
	public void setAlienName(String alienName) {
		this.alienName = alienName;
	}
	public String getAlienRace() {
		return alienRace;
	}
	public void setAlienRace(String alienRace) {
		this.alienRace = alienRace;
	}
	public AlienForm() {
		
	}
	@Override
	public String toString() {
		return "AlienForm [alienNo=" + alienNo + ", alienName=" + alienName
				+ ", alienRace=" + alienRace + "]";
	}
	
	
}
