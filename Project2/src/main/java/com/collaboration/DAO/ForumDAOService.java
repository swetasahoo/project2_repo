package com.collaboration.DAO;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaboration.model.Forum;
import com.collaboration.model.ForumComments1234;

@Service
public class ForumDAOService {

	@Autowired
	ForumDAO fdi;
	/*@Autowired
	CommentDAO forumcomments;
	public void save(Forum f,Principal p)
	{
		f.setForumcomments(forumcomments.getCommentId(p.getName()));
		//System.out.println("Inside Forum Dao service" +forumcomments.getCommentId().getCommentid());
		fdi.save(f,p);
		
	}
	public List<Forum> getAllForum()
	{
		return fdi.getAllForum();
	}
	public ForumComments1234 getComments(String id)
	{
		
		return forumcomments.getCommentId(id);
	}*/
	public void addComments(ForumComments1234 f,Principal p)
	{
		fdi.addComments(f, p);
	}
}
