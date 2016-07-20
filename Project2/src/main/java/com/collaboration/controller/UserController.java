package com.collaboration.controller;


import java.io.File;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.collaboration.DAO.BlogDAOService;
import com.collaboration.DAO.CommentDAOService;
import com.collaboration.DAO.ForumDAOService;
import com.collaboration.DAO.OnlineDAOService;
import com.collaboration.DAO.UserDAOService;
import com.collaboration.DAO.UserStatusDAO;
import com.collaboration.DAO.UserStatusDAOService;
import com.collaboration.model.Forum;
import com.collaboration.model.ForumComments1234;
import com.collaboration.model.MyBlog;
import com.collaboration.model.OnlineUsers;
import com.collaboration.model.UserStatus;
import com.collaboration.model.Users;
import com.collaboration.model.uploadImage;





@Controller
public class UserController {
	
	
	@Autowired
	UserDAOService uds;
	
	@Autowired
	OnlineDAOService ods;
	@Autowired
	ForumDAOService fds;
	@Autowired
	CommentDAOService com;
	
	/*public UserController(UserDAOService ud)
	{
		
		this.uds=ud;
		
	}*/
	
	
	@ModelAttribute("userupdate")
	public Users constr()
	{
		return new Users();
	}
	
	@RequestMapping(value="/saveupdate",method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("userupdate") Users user,Model m,Principal p)
	{
		String name = p.getName();
		System.out.println(user.isActive());
		System.out.println(user.getAddress());
	
		//uds.save(user);
		uds.saveorUpdate(user,name);
		m.addAttribute("u",user); 	
		return "redirect:/home";
	}
	@RequestMapping("/profileupdate")
	public ModelAndView profilepage(Principal principal)
	{
		
		String name = principal.getName();
		System.out.println(name);
		String nm=uds.getUserName(name);
		Users u=uds.getUserDetails(name);
		//m.addAttribute("name",nm);
		//m.addAttribute("user",u);
		System.out.println(u.getEmail());
		System.out.println("address"+u.getAddress());
		System.out.println(u.getPhno());
		//ModelAndView o=new ModelAndView("profileupdate");
		
		return new ModelAndView("profileupdate","user211",u);
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
			File dir=null;
			System.out.println("file try");
			try{
			 dir = new File("C:\\test111");
			 
			if (!dir.exists())
			{
				dir.mkdirs();
				System.out.println("directory created");
			}
			outputStream = new FileOutputStream(dir+ "\\"+p.getName()+".jpg");
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
			//outputStream = new FileOutputStream("C:\\test111\\"	+ p.getName()+".jpg");
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
			//session.setAttribute("uploadFile", "C:\\test111\\"+ p.getName()+".jpg");
			session.setAttribute("uploadFile", dir+"\\"+ p.getName()+".jpg");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			return "redirect:/home";
			
	}
	
	
	
	
	
	
	
	
}
