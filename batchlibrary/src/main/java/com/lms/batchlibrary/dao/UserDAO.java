package com.lms.batchlibrary.dao;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lms.batchlibrary.entity.User;

@Repository
@Transactional
public class UserDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	public User getUserByID(long id) {
		return entityManager.find(User.class, id);
		
	}
	
	public void saveUserData(User user) {
		Session session = entityManager.unwrap(Session.class);
		
		User userFromSession = session.load(User.class, user.getId());
		
		entityManager.persist(userFromSession);
	}
	
	
}
