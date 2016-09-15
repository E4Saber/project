package com.alienwar.demo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author XQL
 * Alien POJO
 */
public class Alien {
	
	/**
	 * alienNo 身份识别ID
	 */
	@NotNull
	@Size(min=3, max=10)
	private String alienNo;
	
	/**
	 * ALIENNAME  名字
	 */
	@NotNull
	@Size(min=3, max=10)
	private String alienName;
	
	/**
	 * alienrace 种族
	 */
	@NotNull
	@Size(min=3, max=10)
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
	
	public Alien() {
		
	}
	@Override
	public String toString() {
		return "Alien [alienNo=" + alienNo + ", alienName=" + alienName
				+ ", alienRace=" + alienRace + "]";
	}
	
	

}
