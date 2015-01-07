package com.wordpress.dudilugasi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wordpress.dudilugasi.model.Coupon;
import com.wordpress.dudilugasi.model.CouponException;
import com.wordpress.dudilugasi.model.HibernateCouponsDAO;

@WebServlet("/adminProducts")
public class AdminProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminProducts() {
		super();

	}

	
	/**
	 * validate admin
	 * then get coupons from database and send it to the view
	 * 
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// check if a attribute called userName exist
		// if so we will give the user the products page
		// if not we will direct him back to the log in page
		String userName = (String) request.getSession()
				.getAttribute("userName");
		if (userName == null) {
			response.sendRedirect("login");
			return;
		} else {
			try {
				List<Coupon> list = HibernateCouponsDAO.getInstance()
						.getCoupons();
				getServletContext().setAttribute("couponsList", list);
				request.getRequestDispatcher("/WEB-INF/adminProducts.jsp")
						.forward(request, response);
			} catch (CouponException e) {
				e.printStackTrace();
			}
		}

	}

}
