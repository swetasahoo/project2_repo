package com.collaboration.DAO;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.Forum;
import com.collaboration.model.ForumComments1234;
import com.collaboration.model.Users;



@Repository
@Transactional
public class CommentDAOImpl implements CommentDAO {
	@Autowired
	private SessionFactory sf;
	ForumComments1234 myforum;
	Principal p;
	int f1;
	public void save(ForumComments1234 f)
	{
		//f1=myforum.getCommentid();
		Session s=sf.openSession();
		/*Forum ff=(Forum) s.get(Forum.class, new Integer(f1));
		String userId=p.getName();
		Users u=(Users)s.get(Users.class, new String(userId));
		List<Users> users=new ArrayList();
		users.add(u);
		List<Forum> forum=new ArrayList();
		forum.add(ff);
		f.setForum(forum);
		//f.setUser(users);
		f.setCommentid(p.getName());
		s.save(f);
		s.flush();
		myforum=f;*/
		s.close();
	}

	@Override
	public ForumComments1234 getCommentId(String id) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		myforum=(ForumComments1234) s.get(ForumComments1234.class, new String(id));
		 return myforum;
	}
}
