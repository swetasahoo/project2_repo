package com.collaboration.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaboration.model.OnlineUsers;

@Service
public class OnlineDAOService
{
	@Autowired
	OnlineDAO odi;
	public List<OnlineUsers> getAllUser()
	{
		return odi.getAllOnlienUsers();
	}
	public void save(OnlineUsers ou)
	{
		odi.save(ou);
	}
}