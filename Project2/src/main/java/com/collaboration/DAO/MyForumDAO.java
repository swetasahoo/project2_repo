package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.MyForum;

public interface MyForumDAO {

	public MyForum getForumByUser(String Username);
	public void getCommentsByUser(String Username);
	public int addNewForum(MyForum f);
	public List<MyForum> getAllForum();
}
