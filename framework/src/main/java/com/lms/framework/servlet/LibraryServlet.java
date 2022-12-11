package com.lms.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebServlet(urlPatterns = "/library.do")
public class LibraryServlet extends HttpServlet{
	private Logger logger = LoggerFactory.getLogger(LibraryServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -335096650383147006L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("doGet methid in LibraryServlet ");
		
		PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>" +
	             "<title>LMS</title>" +
	             "</head>");
	    out.println("<body>" +
	             "<H2>Welcome to the Library Management System!</H2>" +
	             "</body>");
	    out.println("</html>");
		
	}
}
