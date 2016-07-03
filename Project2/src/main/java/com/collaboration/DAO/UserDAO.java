package com.collaboration.DAO;

import com.collaboration.model.UserRole;
import com.collaboration.model.Users;

public interface UserDAO {
	public void save(Users o);
	public String getUserName(String uname);
	public Users getUserDetails(String name);
	//public Users updateStatus(Users status);
	public Users updateStatus(String stat, String name);
}
