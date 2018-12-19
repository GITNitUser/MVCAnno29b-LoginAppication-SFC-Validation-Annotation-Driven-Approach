package com.nt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nt.command.LoginCommand;
import com.nt.dto.LoginDTO;
import com.nt.service.LoginService;

@Controller
@SessionAttributes("loginCmd") /*<--keeping command class object in request scope*/
//@RequestMapping("/login1.htm")
public class LoginController2 {
	@Autowired
	private LoginService service;
	
	//in this case also it will keep command class object in session scope bcoz of @SessionAttributes("loginCmd")
	@RequestMapping(value="/login1.htm",method=RequestMethod.GET)
	public String showForm(Map<String,Object> map) {
		LoginCommand cmd=null;
		
		//create command class object
		cmd=new LoginCommand();
		map.put("loginCmd", cmd);
		
		return "login_form";
	}//end of showForm method

	
	/*
	 //in this case also it will keep command class object in session scope bcoz of @SessionAttributes("loginCmd")
	 @RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(ModelMap model) {
		LoginCommand cmd=null;
		
		//create command class object
		cmd=new LoginCommand();
		model.addAttribute("loginCmd", cmd);
		
		return "login_form";
	}//end of showForm method
*/	
	/*
	 //in this case also it will keep command class object in session scope bcoz of @SessionAttributes("loginCmd")
	 @RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(Model model) {
		LoginCommand cmd=null;
		
		//create command class object
		cmd=new LoginCommand();
		model.addAttribute("loginCmd", cmd);
		
		return "login_form";
	}//end of showForm method
*/	
	
	/* in this case it is not possible to keep command class object in request scope bcoz already handler method keeping this object in request scope
	 @RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute(value="loginCmd") LoginCommand cmd) {
		return "login_form";
	}//end of showForm method
*/	
	
	@RequestMapping(value="/login1.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object> map,@ModelAttribute("loginCmd") LoginCommand cmd,BindingResult errors) {
		String msg=null;
		LoginDTO dto=null;
		
		//create the dto class object
		dto=new LoginDTO();
		//copy the command object data into DTO class object data
		BeanUtils.copyProperties(cmd, dto);
		
		//call the service class method to get the response
		msg=service.login(dto);
		map.put("msg", msg);
		
		return "login_form";
	}//end of processForm request
}//end of class
