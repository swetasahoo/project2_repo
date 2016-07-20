package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.UserStatus;

public interface UserStatusDAO {
	public void save(UserStatus o);
	public List<UserStatus> getUserStatus(String username);
}
