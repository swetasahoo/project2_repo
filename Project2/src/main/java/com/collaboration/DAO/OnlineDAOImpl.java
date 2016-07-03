package com.collaboration.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.OnlineUsers;

@Repository
@Transactional
public class OnlineDAOImpl implements OnlineDAO
{
	@Autowired
	SessionFactory sf;

	@Override
	public List<OnlineUsers> getAllOnlienUsers() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		org.hibernate.Query q= s.createQuery("from OnlineUsers where isOnline=:res");
		q.setParameter("res", true);
		List<OnlineUsers> l=q.list();
		/*List name=new ArrayList<>();
		for(OnlineUsers ou:l)
		{
			name.add(ou.getUsername());
		}*/
		return l;
	}
	
	public void save(OnlineUsers ou)
	{
		Session s=sf.openSession();
		s.save(ou);
		s.flush();
		s.close();
		
	}
	
}