package com.collaboration.controller;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.collaboration.DAO.BlogDAOService;
import com.collaboration.DAO.OnlineDAOService;
import com.collaboration.DAO.UserDAOService;
import com.collaboration.model.MyBlog;
import com.collaboration.model.OnlineUsers;
import com.collaboration.model.Users;
import com.collaboration.model.uploadImage;





@Controller
public class UserController {
	
	
	@Autowired
	UserDAOService uds;
	@Autowired
	BlogDAOService bds;
	@Autowired
	OnlineDAOService ods;
	/*public UserController(UserDAOService ud)
	{
		
		this.uds=ud;
		
	}*/
	@ModelAttribute("blogpage")
	public MyBlog construct()
	{
		System.out.println("hell");
		return new MyBlog();
	}
	@RequestMapping(value="/saveblog",method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("blogpage") MyBlog bl1,Model m)
	{
		System.out.println("add blog");
		//System.out.println(user.isActive());
		//uds.save(user);
		//m.addAttribute("u",user); 	
		return "sendAdmin";
	}
	@RequestMapping("/addblog")
	public ModelAndView addblogpage()
	{
		
		ModelAndView o=new ModelAndView("Addblog");
		return o;
	}
	
	@RequestMapping("/Blog")//Blog
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
	@ModelAttribute("user")
	public Users constr()
	{
		return new Users();
	}
	
	@RequestMapping(value="/saveupdate",method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") Users user,Model m)
	{
		
		System.out.println(user.isActive());
		//uds.save(user);
		//m.addAttribute("u",user); 	
		return "";
	}
	@RequestMapping("/profileupdate")
	public String profilepage(Principal principal,Model m)
	{
		String name = principal.getName();
		System.out.println(name);
		String nm=uds.getUserName(name);
		Users u=uds.getUserDetails(name);
		m.addAttribute("name",nm);
		m.addAttribute("user",u);
		//ModelAndView o=new ModelAndView("profileupdate");
		
		return "profileupdate";
	}
	@RequestMapping("/uploadimage")
	public ModelAndView uploadimage()
	{
		ModelAndView o=new ModelAndView("uploadimage");
		
		return o;
	}
	@ModelAttribute("uploadimage1")
	public uploadImage uploadImage()
	{
		return new uploadImage();
	}
	@RequestMapping("upload")
	public String upload(@ModelAttribute("uploadimage1") uploadImage up, BindingResult res,HttpSession session,Principal p)
	{
		try {

			MultipartFile filea = up.getFileData();

			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (filea.getSize() > 0) {
			inputStream = filea.getInputStream();
			// File realUpload = new File("C:/");
			outputStream = new FileOutputStream("C:\\test111\\"	+ p.getName()+".jpg");
			System.out.println("====22=========");
			System.out.println(filea.getOriginalFilename());
			System.out.println("=============");
			int readBytes = 0;
			byte[] buffer = new byte[8192];
			while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
			System.out.println("===ddd=======");
			outputStream.write(buffer, 0, readBytes);
			}
			outputStream.close();
			inputStream.close();
			session.setAttribute("uploadFile", "C:\\test111\\"+ p.getName()+".jpg");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			return "redirect:/home";
			
	}
	
	@RequestMapping("/chatwindow")
	public ModelAndView chatpage(Principal principal)
	{
		/*String name = principal.getName();
		
		String nm=uds.getUserName(name);
		ods.save(new OnlineUsers(nm,true));
		
		List<OnlineUsers> l=ods.getAllUser();*/
		
		ModelAndView o=new ModelAndView("chat");
		
		return o;
	}
	
	@RequestMapping("update")
public String updateStatus(HttpServletRequest r, Principal p)
{
String stat=r.getParameter("status");
String name=p.getName();
uds.updateStatus(stat,name);
return "redirect:/home";

}
	
	
}
