package com.collaboration.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.MyBlog;
import com.collaboration.model.UserStatus;

@Repository
@Transactional
public class UserStatusDAOImpl implements UserStatusDAO{
	@Autowired
	private SessionFactory sf;
	
	public void save(UserStatus o)
	{
		Session s=sf.openSession();
		s.getTransaction().begin();
	//o.getUser().setUserstatus(o);
		s.saveOrUpdate(o);
		s.flush();
		s.getTransaction().commit();
		
	}
	public List<UserStatus> getUserStatus(String username)
	{
		Session s=sf.getCurrentSession();
		org.hibernate.Query q=s.createQuery("from UserStatus where username=:res");
		q.setParameter("res",username);
		List<UserStatus> statuslist=q.list();
		return statuslist;
	}
	
}
