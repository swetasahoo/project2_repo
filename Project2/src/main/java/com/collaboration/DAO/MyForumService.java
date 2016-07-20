package com.collaboration.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaboration.model.MyForum;

@Service
public class MyForumService {

	@Autowired
	MyForumDAO f1;
	
	public int addNewForum(MyForum f) {
		// TODO Auto-generated method stub
		return f1.addNewForum(f) ;
	}
	public void getForumByUser(String Username) {
		// TODO Auto-generated method stub
		f1.getCommentsByUser(Username);
	}
	public List<MyForum> getAllForum()
	{
		return f1.getAllForum();
	}
}