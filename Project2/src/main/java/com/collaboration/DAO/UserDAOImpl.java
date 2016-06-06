package com.collaboration.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.model.UserRole;
import com.collaboration.model.Users;


@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sf;
	
	public UserDAOImpl()
	{
		
	}
	public void save(Users o,UserRole r)
	{
		Session s=sf.openSession();
		try{
			s.getTransaction().begin();
			s.save(o);	
			s.save(r);
			
			s.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			s.getTransaction().rollback();
			
		}
		
		s.flush();
		s.close();
		
	}
}
