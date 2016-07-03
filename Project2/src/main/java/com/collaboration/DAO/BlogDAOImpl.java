package com.collaboration.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.MyBlog;

@Repository
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sf;
	
	public void save(MyBlog b)
	{
		Session s=sf.openSession();
		s.save(b);
		s.flush();
		s.close();
	}
}
