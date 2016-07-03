package com.collaboration.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.UserRole;
import com.collaboration.model.Users;



@Service
public class UserDAOService {
	
	@Autowired
	UserDAO udi;
	
	/*public UserDAOService(UserDAOImpl udi) {
	
		this.udi=udi;
	}
	*/
	public void save(Users o)
	{
		
		udi.save(o);
		
	}
	public String getUserName(String uname)
	{
		return udi.getUserName(uname);
	}
	public Users getUserDetails(String name)
	{
		return udi.getUserDetails(name);
	}
	public Users updateStatus(String stat, String name) {
		return udi.updateStatus(stat,name);
		
		// TODO Auto-generated method stub
		
	}
}
