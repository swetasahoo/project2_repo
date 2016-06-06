package com.collaboration.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.collaboration.DAO.UserDAOService;
import com.collaboration.model.UserRole;
import com.collaboration.model.Users;



@Controller
public class LoginController {
	
	@Autowired
	UserDAOService uds;
	
	@Autowired
	public LoginController(UserDAOService ud)
	{
		this.uds=ud;
	}
	@RequestMapping("/")
	public String login(@RequestParam (value="error", required = false) String error,
            @RequestParam (value="logout", required = false) String logout, Model model)
	{
		
		if(error != null) {
	           model.addAttribute("error", "Invalid username and password!");
	       }

	       if(logout!= null) {
	           model.addAttribute("msg", "You have been logged out successfully.");
	       }
	       return "login";
	}
	@RequestMapping("/login")
	public ModelAndView loginpage()
	{
		ModelAndView o=new ModelAndView("login");
		
		return o;
	}
	@RequestMapping(value="/NewUser",method=RequestMethod.GET)
	public ModelAndView NewUser()
	{
		ModelAndView o=new ModelAndView("NewUserRegistration");
		
		return  o;
	}
	@ModelAttribute("user")
	public Users construct()
	{
		return new Users();
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") Users user,Model m)
	{
		UserRole r=new UserRole();
		
		r.setUsername(user.getUsername());
		r.setRole();
		System.out.println(user.isActive());
		uds.save(user,r);
		m.addAttribute("u",user); 	
		return "success";
	}
	@RequestMapping("/home")
	public ModelAndView homepage()
	{
		ModelAndView o=new ModelAndView("success");
		
		return o;
	}
}
