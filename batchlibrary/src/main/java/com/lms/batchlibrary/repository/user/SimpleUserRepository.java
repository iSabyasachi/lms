package com.lms.batchlibrary.repository.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lms.batchlibrary.entity.User;

@Repository
public class SimpleUserRepository implements BaseRepository<User>{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public SimpleUserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	@Transactional
	public void saveAll(List<User> users) {
		for(User user : users) {			
			jdbcTemplate.update("INSERT INTO T_ACCOUNT_USER (ID, NAME, EMAIL, PHONE, USER_TYPE, MEMBERSHIP_DATE, STATUS,BLOCK_USER, NUM_BOOKS_CHECKED_OUT, DATE_CREATED, LAST_UPDATED)" +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					user.getId(),
					user.getName(),
					user.getEmail(),
					user.getPhone(),
					user.getType(),
					new java.sql.Date(user.getDateOfMembership().getTime()),
					user.getStatus(),
					user.getBlockUser(),
					user.getTotalNumBooksCheckedOut(),
					user.getCreatedTS(),
					user.getUpdatedTS()
					);
		}
		
	}

}
