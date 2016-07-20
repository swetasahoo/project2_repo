package com.collaboration.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.plaf.synth.SynthSeparatorUI;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collaboration.DAO.UserDAOService;
import com.collaboration.DAO.UserStatusDAOService;
import com.collaboration.model.UserStatus;
import com.collaboration.model.Users;

import antlr.collections.List;

@Controller
public class UserStatusController {
	
	@Autowired
	UserStatusDAOService usds;
	@Autowired
	UserDAOService uds;
	
	@RequestMapping("/updateStatus")
	public String upda()
	{
		return "updateStatus";
	}
	@ModelAttribute("status")
	public UserStatus consstatus(Principal p)
	{
		System.out.println("user status");
		Users u=uds.getUserDetails(p.getName());
		
		UserStatus us=new UserStatus();
		us.setUser(u);
		return us;
	}
	@RequestMapping(value="/saveustatus",method=RequestMethod.POST)
	public String doupdatestatus(@ModelAttribute("status") UserStatus us,BindingResult res)
	{
		if(res.hasErrors())
		{
			return "home";
		}
		//String re=null;
		System.out.println("hello status");
		us.setDatetime(new Date());
		usds.save(us);
		return "redirect:/home";
	}
}
