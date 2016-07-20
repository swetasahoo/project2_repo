package com.collaboration.DAO;

import java.security.Principal;
import java.util.List;

import com.collaboration.model.Forum;
import com.collaboration.model.ForumComments1234;

public interface ForumDAO {
	/*public void save(Forum f,Principal p);
	public List<Forum> getAllForum();
	public ForumComments1234 getComments(String id);*/
	public void addComments(ForumComments1234 f,Principal p);
}
