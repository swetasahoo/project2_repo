package com.collaboration.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaboration.model.UserStatus;



@Service
public class UserStatusDAOService {
	@Autowired
	UserStatusDAO udi;
	public void save(UserStatus o)
	{
		
		udi.save(o);
		
	}
	public List<UserStatus> getUserStatus(String username)
	{
		return udi.getUserStatus(username);
	}
}
