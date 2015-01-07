package com.wordpress.dudilugasi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wordpress.dudilugasi.model.CouponException;
import com.wordpress.dudilugasi.model.HibernateCouponsDAO;

@WebServlet("/deleteCoupon")
public class DeleteCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCoupon() {
		super();

	}

	/**
	 * deletes a coupon from the database using the id that the administrator
	 * send in parameter
	 * 
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String userName = (String) request.getSession()
				.getAttribute("userName");
		if (userName == null) {
			response.sendRedirect("Login");
			return;
		}
		//we get the id from the user
		String idString = request.getParameter("id");
		if (idString == null || idString.trim().length() == 0) {
			response.sendRedirect("adminProducts");
			return;
		}
		try {
			HibernateCouponsDAO.getInstance().deleteCoupon(Integer.parseInt(idString));
			response.sendRedirect("adminProducts");
		} catch (NumberFormatException | CouponException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
