package com.lms.batchlibrary.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.batchlibrary.entity.User;
import com.lms.batchlibrary.repository.user.SimpleUserRepository;

@Component
public class UserWriter implements ItemWriter<User>{
	
	@Autowired
	private SimpleUserRepository userRepository;
	//private UserRepository userRepository;
	//private SimpleUserRepository userRepository;
	//private BatchUserRepository userRepository;
	
	
	@Override
	@SuppressWarnings("unchecked")
	public void write(List<? extends User> users) throws Exception {
		System.out.println("Data saved for Users: "+ users);		
		userRepository.saveAll((List<User>) users);
	}

}
