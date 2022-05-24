package com.lms.accesslibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;
import com.lms.accesslibrary.entity.library.user.User;
import com.lms.accesslibrary.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {		
		this.userService = userService;
	}
	
	@GetMapping("/read/one")
	public String readUser() {
		logger.info("Test : Read User method in UserController class is invoked.");	
		
		User user = new User();
		user.setName("Sabyasach");
		return user.toString();
	}
	
	@PostMapping("/adduser")
    public Response addUser(@RequestBody Request request) {
		logger.info("Add User method in UserController class is invoked.");
		
		Response response = userService.addUser(request);

        return response;
    }
	
	@PostMapping("/blockuser")
    public Response blockUser(@RequestBody Request request) {
		logger.info("Block User method in UserController class is invoked.");
		
		Response response = userService.blockUser(request);

        return response;
    }
	
	@PostMapping("/unblockuser")
    public Response unBlockUser(@RequestBody Request request) {
		logger.info("Un Block User method in UserController class is invoked.");
		
		Response response = userService.unBlockUser(request);

        return response;
    }

}
