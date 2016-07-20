package com.collaboration.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.collaboration.DAO.BlogDAOService;
import com.collaboration.DAO.UserDAOService;
import com.collaboration.model.MyBlog;
import com.collaboration.model.MyForum;

@Controller
public class BlogController {

	@Autowired
	BlogDAOService bds;
	@Autowired
	UserDAOService uds;
	
	MyBlog myblog;
	@ModelAttribute("blogpage")
	public MyBlog construct()
	{
		
		myblog=new MyBlog();
		return myblog;
	}

	
	@RequestMapping(value="/saveblog",method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("blogpage") MyBlog bl,BindingResult result,Model m,Principal p)
	{
		
		String re=null;
		
		if(result.hasErrors())
		{
			return "Addblog";
		}
		else
		{
			try{
			MultipartFile filea =bl.getDoc();
			String name=p.getName();
			System.out.println(name);
			String rolename=uds.getUserRole(name);
			
			if(rolename.equals("ROLE_ADMIN"))
			{
				System.out.println("admin ");
			bl.setUsername(name);
			System.out.println(bl.getUsername());
			//System.out.println(filea.getOriginalFilename());
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (filea.getSize() > 0) 
			{
			inputStream = filea.getInputStream();
			// File realUpload = new File("C:/");
			
			File dir = new File("C:\\"+ p.getName());
			if (!dir.exists())
			{
				dir.mkdirs();
				System.out.println("directory created");
			}
			outputStream = new FileOutputStream(dir+"\\"+filea.getOriginalFilename());
			int readBytes = 0;
			byte[] buffer = new byte[10000];
			while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
			{
			System.out.println("===ddd=======");
			outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			
			inputStream.close();
			System.out.println("file uploaded");
			int res=bds.addNewBlog(bl);
			if(res==1)
			{
				System.out.println("data inserted");
			}	
			}
			 re= "redirect:/addblog";
			}//if close
			else
			{
				bl.setUsername(name);
				System.out.println(bl.getUsername());
				System.out.println(filea.getOriginalFilename());
				InputStream inputStream = null;
				OutputStream outputStream = null;
				if (filea.getSize() > 0) 
				{
				inputStream = filea.getInputStream();
				// File realUpload = new File("C:/");
				
				File dir = new File("C:\\"+ p.getName());
				if (!dir.exists())
				{
					dir.mkdirs();
					System.out.println("directory created");
				}
				outputStream = new FileOutputStream(dir+"\\"+filea.getOriginalFilename());
				int readBytes = 0;
				byte[] buffer = new byte[10000];
				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
				{
				System.out.println("===ddd=======");
				outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				
				inputStream.close();
				System.out.println("file uploaded");
				int res=bds.addNewBlog(bl);
				if(res==1)
				{
					System.out.println("data inserted");
				}
				}
				re= "sendAdmin";
			} //else close
			 
			}
			catch (Exception e) {
			e.printStackTrace();
			}
			
		}
		return re;
	}
	@RequestMapping("/addblog")
	public ModelAndView addblogpage(Principal principal)
	{
		String name = principal.getName();
		System.out.println(name);
		String nm=uds.getUserName(name);
		String rolename=uds.getUserRole(name);
		ModelAndView o=new ModelAndView("Addblog");
		o.addObject("pendingblog",bds.getBlogforApproval());
		o.addObject("rolename",uds.getUserRole(name));
		System.out.println(rolename);
		o.addObject("name",name);
		o.addObject("uname",nm);
		return o;
	}
	
	@RequestMapping("/Blog")//Blog
	public String blogpage(Principal principal,HttpServletRequest request, Model m)
	{
		//ModelAndView o=new ModelAndView("Blog");
		String name = principal.getName();
		
		System.out.println(name);
		String nm=uds.getUserName(name);
		m.addAttribute("approvedblog",bds.approvedBlogClient());
		m.addAttribute("name",name);
		m.addAttribute("uname",nm);
		
		
		return "Blog";
	}
	@RequestMapping("/approved/{id}")
	public String approvedBlog(@PathVariable("id") int id)
	{
		bds.approveBlog(id);
		return "redirect:/addblog";
	}
	@RequestMapping("/delete/{id}")
	public String deleteBlog(@PathVariable("id") int id)
	{
		System.out.println(id);
		bds.deleteBlog(id);
		return "redirect:/addblog";
	}
}
