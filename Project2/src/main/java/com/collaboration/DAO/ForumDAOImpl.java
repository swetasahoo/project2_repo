package com.collaboration.DAO;

import java.security.Principal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.Forum;
import com.collaboration.model.ForumComments1234;
import com.collaboration.model.OnlineUsers;


@Repository
@Transactional
public class ForumDAOImpl implements ForumDAO {
	
	@Autowired
	private SessionFactory sf;
	//@Autowired
	private ForumComments1234 forumcomments;
	@Override
	public void addComments(ForumComments1234 f,Principal p) {
		// TODO Auto-generated method stub
		//Principal p;
		String unm=p.getName();
		f.setUsername(unm);
		Session s=sf.getCurrentSession();
		s.save(f);
		
	}
	
	/*public void save(Forum f,Principal p)
	{
		//Principal p = null;
		//CommentDAOImpl cd = new CommentDAOImpl();
		ForumComments1234 forumcomments=getComments(p.getName());//=ew ForumComments1234();
		//forumcomments=cd.getCommentId();
		System.out.println("Inside forum dao impl"+forumcomments.getCommentid());
		Session s=sf.openSession();
		f.setForumcomments(forumcomments);
		s.save(f);
		s.flush();
		s.close();
	}

	@Override
	public List<Forum> getAllForum() {
		// TODO Auto-generated method stub
		Session s=sf.getCurrentSession();
		org.hibernate.Query q= s.createQuery("from Forum");
		
		List<Forum> l=q.list();
		return l;
	}

	@Override
	public ForumComments1234 getComments(String id) {
		// TODO Auto-generated method stub
		Principal p = null;
		id=p.getName();
		Session s=sf.getCurrentSession();
		ForumComments1234 f=(ForumComments1234) s.get(ForumComments1234.class, id);
		return f;
	}*/
}
