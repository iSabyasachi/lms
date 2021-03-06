package com.lms.accesslibrary.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lms.accesslibrary.entity.User;

@Repository
@Transactional
public class UserDAO extends BaseDAO implements IUserDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public User insertUser(User user){
	   return entityManager.merge(user);
	}

	public User updateUser(User user){
	   return entityManager.merge(user);
	}
	
	public User getUserById(int id) {
	    return entityManager.find(User.class, id);                
	}
	
	public void deleteUserById(int id){
		User user = entityManager.find(User.class, id);
	    entityManager.remove(user);
	}

}
