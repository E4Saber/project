package com.alienwar.demo.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;


/**
 * 
 * @author XQL
 * AlienFile
 */
public class AlienFile {
	
	/** AlienNo **/
	@NotNull
	private String alienNo;
	
	/** 所属的ImageFile **/
	private List<MultipartFile> imageFile;
	
	
	
	public String getAlienNo() {
		return alienNo;
	}
	public void setAlienNo(String alienNo) {
		this.alienNo = alienNo;
	}
	public List<MultipartFile> getImageFile() {
		return imageFile;
	}
	public void setImageFile(List<MultipartFile> imageFile) {
		this.imageFile = imageFile;
	}
	
	
	public AlienFile() {
		
	}
	
	
	

}
