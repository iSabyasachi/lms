package com.lms.accesslibrary.dao;

import com.lms.accesslibrary.entity.User;

public interface iUserDAO {	

	public User insertUser(User user);
	public User updateUser(User user);
	public User getUserById(int id);
	public void deleteUserById(int id);

}
