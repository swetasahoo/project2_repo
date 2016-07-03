package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.OnlineUsers;
import com.collaboration.model.Users;

public interface OnlineDAO
{
	public void save(OnlineUsers ou);
	public List<OnlineUsers> getAllOnlienUsers();
	
}