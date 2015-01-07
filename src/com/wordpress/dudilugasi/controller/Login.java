package com.wordpress.dudilugasi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * login servlet
 * 
 *
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}
	
	/**
	 * user get the view of the log in form
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp")
		.forward(request, response);
	}

	/**
	 * validate username and password
	 * if it correct redirect to the admin interface
	 * if not back to the login page
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		
		//we will check if the password and user name matches the database
		if (username.equals("dudi") && password.equals("123")) {
			request.getSession().setAttribute("userName", username);
			response.sendRedirect("adminProducts");
		}
		else {
			response.sendRedirect("Login");
		}
	}

}
