package com.collaboration.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.MyBlog;
import com.collaboration.model.MyForum;

@Repository
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sf;
	
	
	public void approveBlog(int id)
	{
		 Session s=sf.openSession();
			Transaction t=s.beginTransaction();
			MyBlog b=(MyBlog)s.get(MyBlog.class, new Integer(id));	
			b.setApprove(1);
			s.update(b);
			t.commit();
			s.flush();
			s.close();
	}
	
	 public void deleteBlog(int id)
	 {
		 Session s=sf.openSession();
			Transaction t=s.beginTransaction();
			MyBlog b=(MyBlog)s.get(MyBlog.class, new Integer(id));	
			s.delete(b);
			t.commit();
			s.flush();
			s.close();
	 }
	 

	@Override
	public int addNewBlog(MyBlog b) {
		
		Session s=sf.openSession();
		s.getTransaction().begin();
		s.save(b);
		s.flush();
		s.getTransaction().commit();
		
		
		return 1;
	}
	public List<MyBlog> getBlogforApproval()
	{
		Session s=sf.getCurrentSession();
		org.hibernate.Query q=s.createQuery("from MyBlog where approve=:res");
		q.setParameter("res",0);
		List<MyBlog> bloglist=q.list();
		return bloglist;
	}

	@Override
	public List<MyBlog> approvedBlogClient() {
		Session s=sf.getCurrentSession();
		org.hibernate.Query q=s.createQuery("from MyBlog where approve=:res");
		q.setParameter("res",1);
		List<MyBlog> bloglist=q.list();
		return bloglist;
	}
}
