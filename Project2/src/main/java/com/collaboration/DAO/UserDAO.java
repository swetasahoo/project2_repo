package com.collaboration.DAO;

import com.collaboration.model.UserRole;
import com.collaboration.model.Users;

public interface UserDAO {
	public void save(Users o,UserRole r);
}
