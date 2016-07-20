package com.collaboration.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.MyBlog;
import com.collaboration.model.MyForum;


@Service
public class BlogDAOService {

	@Autowired
	BlogDAO bdi;
	/*public void save(MyBlog b)
	{
		
		bdi.save(b);
		
	}*/
	public int addNewBlog(MyBlog f) {
		// TODO Auto-generated method stub
	
		return bdi.addNewBlog(f) ;
	}
	public List<MyBlog> getBlogforApproval()
	{
		return bdi.getBlogforApproval();
	}
	public void deleteBlog(int id)
	{
		bdi.deleteBlog(id);
	}
	public void approveBlog(int id)
	{
		bdi.approveBlog(id);
	}
	public List<MyBlog> approvedBlogClient()
	{
		return bdi.approvedBlogClient();
	}
}
