package com.alienwar.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alienwar.demo.form.AlienFile;
import com.alienwar.demo.form.AlienForm;
import com.alienwar.demo.serviceimpl.AlienServiceImpl;


/**
 * 
 * @author XQL
 *	AlienController 控制器
 */

@Controller
public class AlienController {
	
	
	/**  AlienService 自动注入 **/
	@Autowired
	private AlienServiceImpl alienService;
	
	
	/**
	 * alienLogin
	 * @return
	 */
	@RequestMapping(value="login")
	public String alienLogin(@Valid AlienForm alienForm, Errors errors, Model model){
		System.out.println("test:alienForm" + alienForm);
	
		if (errors.hasErrors()) {
			System.out.println("Error!" + errors.getAllErrors().get(0).getDefaultMessage());
			return "details";
		}
		model.addAttribute("alien", alienForm);
		alienService.alienLogin(alienForm);

		return "login";
	}
	
	/**
	 * @param AlienForm 页面的alien对象
	 * @param Model  model对象 用于存储  传递与显示
	 * @return
	 */
	@RequestMapping(value="save")
	public String saveAlien(@Valid AlienForm alienForm,BindingResult result , Model model) {
		if (result.hasErrors()) {
			model.addAttribute("alien", alienForm);
			model.addAttribute("errors", result.getAllErrors());
			System.out.println("Error!");

			return "error";
		}	
		
		model.addAttribute("alien",alienForm);
		alienService.alienLogin(alienForm);
		
		return "redirect:/login" + alienForm.getAlienName();
	}

	
	/**
	 * @param alienFile 上传的文件
	 * @return 跳转
	 */
	@RequestMapping(value="fileUpload")
	public String fileUpload(HttpServletRequest servletRequest, @Valid AlienFile alienFile,BindingResult bindingResult, Model model) {
		if (alienFile != null) {
			List<MultipartFile> files = alienFile.getImageFile();
			List<String> fileNames = new ArrayList<String>();
			
			if (null != files && files.size() > 0) {
				for (MultipartFile multipartFile : files) {
					String fileName = multipartFile.getOriginalFilename();
					fileNames.add(fileName);
					File uploadFile = new File(servletRequest.getSession().getServletContext().getRealPath("/file"), fileName);
					
					try {
						multipartFile.transferTo(uploadFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
					//save alienFile
					model.addAttribute("alienFile", alienFile);
					return "alienFile";
				}
			}
			
			
			return "error";
		} else {
			return "error";
		}
	}
}
