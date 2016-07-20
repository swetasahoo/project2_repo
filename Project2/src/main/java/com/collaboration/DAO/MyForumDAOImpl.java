package com.collaboration.DAO;

import java.security.Principal;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.Forum;
import com.collaboration.model.ForumComments1234;
import com.collaboration.model.MyForum;

@Repository
@Transactional
public class MyForumDAOImpl implements MyForumDAO{

	@Autowired
	SessionFactory sf;
	@Override
	public MyForum getForumByUser(String Username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getCommentsByUser(String Username) {
		// TODO Auto-generated method stub
		Session s=sf.getCurrentSession();
		
		//return "forum";
	}

	@Override
	public int addNewForum(MyForum f) {
		Session s=sf.getCurrentSession();
		//s.beginTransaction();
		/*System.out.println(f.getForumcomments());
		System.out.println(f.getForumtitle());
		System.out.println(f.getUsername());*/
		s.save(f);
		return 1;
	}

	@Override
	public List<MyForum> getAllForum() {
		// TODO Auto-generated method stub
		Session s=sf.getCurrentSession();
		org.hibernate.Query q=s.createQuery("from MyForum");
		List<MyForum> list=q.list();
		
		return list;
	}

	

}
