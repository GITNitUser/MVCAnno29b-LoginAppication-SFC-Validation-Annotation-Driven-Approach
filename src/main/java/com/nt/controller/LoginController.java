package com.nt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nt.command.LoginCommand;
import com.nt.dto.LoginDTO;
import com.nt.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(Map<String,Object> map) {
		LoginCommand cmd=null;
		
		//create command class object
		cmd=new LoginCommand();
		map.put("loginCmd", cmd);//keeping command class object in request scope by default. but you can change its scope by @SessionAttributes("loginCmd")
		
		return "login_form";
	}//end of showForm method

	
	/*
	 //In this case it will keep command class object in request scope only and you can not change its scope also by @SessionAttributes("loginCmd")
	 @RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute(value="loginCmd") LoginCommand cmd) {
		return "login_form";
	}//end of showForm method
*/	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object> map,@Valid@ModelAttribute("loginCmd") LoginCommand cmd,BindingResult errors) {
		String msg=null;
		LoginDTO dto=null;
		
		//create the dto class object
		dto=new LoginDTO();
		//if error is there then return the response as same page
		if(errors.hasErrors()) {
			return "login_form";
		}
		//copy the command object data into DTO class object data
		BeanUtils.copyProperties(cmd, dto);
		
		//call the service class method to get the response
		msg=service.login(dto);
		map.put("msg", msg);
		
		return "login_form";
	}//end of processForm request
}//end of class
