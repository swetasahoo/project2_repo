package com.collaboration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.collaboration.DAO.UserDAOService;





@Controller
public class UserController {
	
	
	@Autowired
	UserDAOService uds;
	
	@Autowired
	public UserController(UserDAOService ud)
	{
		this.uds=ud;
	}
	
	
	@RequestMapping("/Blog")
	public ModelAndView blogpage()
	{
		ModelAndView o=new ModelAndView("Blog");
		
		return o;
	}
	@RequestMapping("/forum")
	public ModelAndView forumpage()
	{
		ModelAndView o=new ModelAndView("forum");
		
		return o;
	}
	@RequestMapping("/chatwindow")
	public ModelAndView chatpage()
	{
		
		ModelAndView o=new ModelAndView("chatwindow");
		
		return o;
	}
	
	

	
	
}
