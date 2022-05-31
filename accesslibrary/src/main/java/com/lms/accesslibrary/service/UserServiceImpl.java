package com.lms.accesslibrary.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.accesslibrary.bo.UserBO;
import com.lms.accesslibrary.dto.Request;
import com.lms.accesslibrary.dto.Response;
import com.lms.accesslibrary.entity.User;
import com.lms.accesslibrary.enums.UserType;

@Service
public class UserServiceImpl implements iUserService {
	
	@Autowired
	private Response response;
	
	@Autowired
	private UserBO userBO;
	
	
	@Override
	public Response blockUser(Request request) {
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(request.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		/*Find the member detail*/		
		String memberId = String.valueOf(request.getMember().getId());		
		User member = userBO.findRegisteredUser(memberId, UserType.MEMBER.name());
		if(member == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.MEMBER.name()+".");
			return response;
		}
		
		member.setBlockUser(1);		
		member.setUpdatedTS(Timestamp.from(Instant.now()));
		userBO.save(member);	
		
		response.setMessage("You have blocked the user with Id : "+request.getMember().getId());	
		return response;
	}

	@Override
	public Response unBlockUser(Request request) {
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(request.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		/*Find the member detail*/		
		String memberId = String.valueOf(request.getMember().getId());		
		User member = userBO.findRegisteredUser(memberId, UserType.MEMBER.name());
		if(member == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.MEMBER.name()+".");
			return response;
		}
		
		member.setBlockUser(0);		
		member.setUpdatedTS(Timestamp.from(Instant.now()));
		userBO.save(member);	
		
		response.setMessage("You have unblocked the user with Id : "+request.getMember().getId());	
		return response;
	}

	@Override
	public Response addUser(Request request) {
		/*Find the librarian detail*/		
		String librarianId = String.valueOf(request.getLibrarian().getId());		
		User librarian = userBO.findRegisteredUser(librarianId, UserType.LIBRARIAN.name());
		if(librarian == null) {
			response.setMessage("FAILED!!! User is not found or is not a "+UserType.LIBRARIAN.name()+".");
			return response;
		}
		
		User member = request.getMember();
		member.setDateOfMembership(new Date());
		member.setCreatedTS(Timestamp.from(Instant.now()));
		member.setUpdatedTS(Timestamp.from(Instant.now()));
		userBO.save(member);	
		
		response.setMessage("You have successfully added the user with name : "+member.getName());	
		return response;
	}

}
