package com.lms.batchlibrary.batch;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.lms.batchlibrary.entity.User;
import com.lms.batchlibrary.model.UserBean;

@Component
public class UserProcessor implements ItemProcessor<UserBean, User>{
	
	@Override
	public User process(UserBean userBean) throws Exception {
		System.out.println("In UserProcessor "+userBean);
		
		User user = new User();
		user.setId(userBean.getId());
		user.setName(userBean.getName());
		user.setEmail(userBean.getEmail());
		user.setPhone(userBean.getPhone());
		user.setType(userBean.getType());
		
		LocalDate localDate = LocalDate.parse(userBean.getDateOfMembership());
		Date dateOfMemberShip = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		user.setDateOfMembership(dateOfMemberShip);
		user.setStatus(userBean.getStatus());
		
		user.setBlockUser(0);
		user.setTotalNumBooksCheckedOut(0);
		user.setCreatedTS(Timestamp.from(Instant.now()));
		user.setUpdatedTS(Timestamp.from(Instant.now()));
		
		return user;
	}

}
