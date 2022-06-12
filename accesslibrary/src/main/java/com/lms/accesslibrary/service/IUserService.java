package com.lms.accesslibrary.service;

import org.springframework.stereotype.Service;

import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;

@Service
public interface IUserService {	
	
	public Response addUser(Request request);
	public Response blockUser(Request request);
	public Response unBlockUser(Request request);
}
