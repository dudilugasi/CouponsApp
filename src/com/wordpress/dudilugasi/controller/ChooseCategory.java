package com.wordpress.dudilugasi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chooseCategory")
public class ChooseCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChooseCategory() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// redirect to form asking to choose a category
		request.getRequestDispatcher("/WEB-INF/chooseCategory.jsp").forward(
				request, response);
	}


}
