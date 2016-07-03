package com.collaboration.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.MyBlog;


@Service
public class BlogDAOService {

	@Autowired
	BlogDAO bdi;
	public void save(MyBlog b)
	{
		
		bdi.save(b);
		
	}
	
}
