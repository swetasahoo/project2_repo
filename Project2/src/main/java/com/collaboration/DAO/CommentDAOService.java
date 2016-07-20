package com.collaboration.DAO;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaboration.model.ForumComments1234;


@Service
public class CommentDAOService {
	@Autowired
	CommentDAO bdi;
	public void save(ForumComments1234 f)
	{
		
		bdi.save(f);
		
	}
	public ForumComments1234 getCommentId(String id)
	{
		return bdi.getCommentId(id);
	}
}
