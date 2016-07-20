package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.MyBlog;
import com.collaboration.model.MyForum;


public interface BlogDAO {
	public int addNewBlog(MyBlog b);
	public List<MyBlog> getBlogforApproval();
	public void deleteBlog(int id);
	public void approveBlog(int id);
	public List<MyBlog> approvedBlogClient();
}
