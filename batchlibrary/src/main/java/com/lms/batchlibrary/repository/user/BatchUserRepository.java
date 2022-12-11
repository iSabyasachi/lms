package com.lms.batchlibrary.repository.user;

import java.sql.PreparedStatement;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lms.batchlibrary.entity.User;

@Repository
public class BatchUserRepository implements BaseRepository<User>{
	private JdbcTemplate jdbcTemplate;
	
	public BatchUserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public void saveAll(List<User> users) {
		jdbcTemplate.batchUpdate("INSERT INTO T_ACCOUNT_USER (ID, NAME, EMAIL, PHONE, USER_TYPE, MEMBERSHIP_DATE, STATUS,BLOCK_USER, NUM_BOOKS_CHECKED_OUT, DATE_CREATED, LAST_UPDATED)" +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
		users,
		100, 
		(PreparedStatement ps, User user) -> {
			ps.setLong(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getType());
			ps.setDate(6, new java.sql.Date(user.getDateOfMembership().getTime()));
			ps.setString(7, user.getStatus());
			ps.setInt(8, user.getBlockUser());
			ps.setInt(9, user.getTotalNumBooksCheckedOut());
			ps.setTimestamp(10, user.getCreatedTS());
			ps.setTimestamp(11, user.getUpdatedTS());
		});
	}
	
}
