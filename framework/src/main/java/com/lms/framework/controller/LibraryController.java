package com.lms.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LibraryController {
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to Library Management System<>";
		//return "main-menu";
	}
}
