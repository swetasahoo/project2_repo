package com.collaboration.DAO;

import java.security.Principal;

import com.collaboration.model.ForumComments1234;

public interface CommentDAO {
	public void save(ForumComments1234 f);
	public ForumComments1234 getCommentId(String id);
}
