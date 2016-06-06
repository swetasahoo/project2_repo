package com.collaboration.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.UserRole;
import com.collaboration.model.Users;



@Service
@Transactional
public class UserDAOService {
	
	@Autowired
	UserDAOImpl udi;
	
	/*@Autowired
	public UserDAOService(UserDAOImpl u)
	{
		this.udi=u;
	}*/
	public void save(Users o,UserRole r)
	{
		
		udi.save(o,r);
		
	}

}
