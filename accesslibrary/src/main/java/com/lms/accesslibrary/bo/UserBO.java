package com.lms.accesslibrary.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.accesslibrary.dao.UserRepository;
import com.lms.accesslibrary.entity.user.User;
import com.lms.accesslibrary.enums.UserType;

@Component
public class UserBO {
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> findByUserId(String userId) {
		return userRepository.findById(Long.parseLong(userId));
	}
	
	public User findRegisteredUser(String userId, String type) {		
		Optional<User> userOpt = this.findByUserId(userId);
		if(userOpt.isEmpty()) {
			//errMsg = "FAILED!!! User is not found.";
			return null;
			
		}
		User user = userOpt.get();
		if(!user.getType().equals(type)) {
			//errMsg = "FAILED!!! User is not a "+type+".";	
			return null; 
		}
		
		return user;
	}

	public void save(User user) {
		userRepository.save(user);		
	}

}
