package com.collaboration.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.MyBlog;
import com.collaboration.model.UserRole;
import com.collaboration.model.Users;



@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sf;
	
	/*public UserDAOImpl()
	{
		
	}*/
	public String getUserRole(String name)
	{
		 Session s=sf.openSession();
		 Query q=s.createQuery("from UserRole where username=:uname");
		 q.setParameter("uname", name);
		 List<UserRole> itemList = q.list();
		 String rolenm=null;
		 for(UserRole u:itemList)
		 {
			 rolenm=u.getRole();
		 }
			return rolenm;
	}
	
	public String getUserName(String uname)
	{
	 Session s=sf.openSession();
	 Query q=s.createQuery("from Users where username=:uname");
	 q.setParameter("uname", uname);
	 List<Users> itemList = q.list();
	 String nm=null;
	 for(Users u:itemList)
	 {
		 nm=u.getName();
	 }
		return nm;
	}
	public Users getUserDetails(String name)
	{
		
		Session session = sf.openSession() ;
		session.beginTransaction();
		Users dbuser = (Users) session.get(Users.class,name);

			System.out.println(dbuser.getEmail());
		
		
	 return dbuser;
	}
	public void save(Users o)
	{
		UserRole r=new UserRole();
		System.out.println("e4");
		o.setActive(1);
		System.out.println(o.isActive());
		r.setUsername(o.getUsername());
		r.setRole();
		Session s=sf.openSession();
		//o.getForumcomments1();
		
		try{
			s.getTransaction().begin();
			s.save(o);	
			System.out.println("e5");
			s.save(r);
			s.flush();
			s.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			s.getTransaction().rollback();
			
		}
		System.out.println("e6");
		
		s.close();
		
	}
	public void saveorUpdate(Users u,String name)
	{
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();	
		Users dbuser = (Users) s.get(Users.class,name);		
		s.update(dbuser);
		t.commit();
		s.flush();
		s.close();
		 
	}
	@Override
	public Users updateStatus(String stat, String name) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		//s.beginTransaction();
		Query q=s.createQuery("update Users set status=:s where name=:name");
		q.setString("s", stat);
		q.setString("name",name);
		q.executeUpdate();
		Users dbuser = (Users) s.get(Users.class,name);
		//System.out.println(dbuser.getStatus());
		return dbuser;
	
	}
	
}

