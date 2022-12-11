package com.lms.batchlibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.batchlibrary.dao.UserDAO;
import com.lms.batchlibrary.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public User getUserById(long id) {
		
		return userDAO.getUserByID(id);
	}
	
	public void processUser(long id) {
			
		User user = getUserById(3);	
		user.setName("Ramallal Belluci");
		
		userDAO.saveUserData(user);
		
		//int a = 100 / 0;
		//System.out.println(a);
		
		user.setEmail("Ramallal@gmail.com");
		
		userDAO.saveUserData(user);
		
		System.out.println(user);
	}
	
}
