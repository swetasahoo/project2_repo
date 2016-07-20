package com.collaboration.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.collaboration.DAO.ForumDAOService;
import com.collaboration.DAO.MyForumService;
import com.collaboration.model.ForumComments1234;
import com.collaboration.model.MyForum;

import oracle.net.aso.f;

@Controller
public class ForumController {

	@Autowired
	MyForumService mfs;
	@Autowired
	ForumDAOService fds;
	/*@RequestMapping("/forum")
	public String addForumPage()
	{
		return "AddForum";
	}*/
	
	@RequestMapping("/addforum")
	public ModelAndView addforumpage()
	{
		System.out.println("forum");
		
		ModelAndView o=new ModelAndView("AddForum");
		return o;
	}
	MyForum myforum;
	@ModelAttribute("forumpage")
	public MyForum Myforum()
	{
		
		myforum=new MyForum();
		return myforum;
	}
	@RequestMapping(value="/saveforum",method=RequestMethod.POST)
	public String addForum(@ModelAttribute("forumpage") MyForum f1,BindingResult result, Model m,Principal p)
	{
		if(result.hasErrors())
		{
			return "forum";
		}
		else
		{
			String username=p.getName();
			f1.setUsername(username);
			int res=mfs.addNewForum(f1);
			if(res==1)
			{
				return "redirect:/forum";
			}
			else
			{
				return "redirect:/forum";
			}
		}
	}
	@ModelAttribute("commentspage")
	public ForumComments1234 newComments()
	{
		return new ForumComments1234();
	}
	@RequestMapping(value="/saveComments",method=RequestMethod.POST)
	public String addForumComments(@ModelAttribute("commentspage") ForumComments1234 f1,BindingResult result, Model m,Principal p)
	{
		if(result.hasErrors())
		{
			return "AddForum";
		}
		else
		{
			//String username=p.getName();
			//f1.setUsername(username);
			System.out.println("forum comments "+f1.getMycomment());
			System.out.println("forum id" +myforum.getForumId());
			f1.setForumid(myforum.getForumId());
			fds.addComments(f1, p);
			//mfs.getForumByUser(username);
			
				return "forum";
			
		}
	}
	@RequestMapping("forum")
	public ModelAndView getAllForum()
	{
		List<MyForum> list= mfs.getAllForum();
		ModelAndView mv=new ModelAndView("forum","forum",list);
		
		return mv;
	}
}