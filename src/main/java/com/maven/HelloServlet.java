package com.maven;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	try {
		Message m1 = new Message();
		
		response.setContentType("text/plain");
		response.getWriter().write(m1.getMessage());
		} catch(IOException e) {
			throw new ServletException("IOException encountered in doGet method", e);
		}
	}

}
