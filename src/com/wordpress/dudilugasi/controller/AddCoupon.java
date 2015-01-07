package com.wordpress.dudilugasi.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wordpress.dudilugasi.model.Coupon;
import com.wordpress.dudilugasi.model.CouponException;
import com.wordpress.dudilugasi.model.HibernateCouponsDAO;


/**
 * adding a coupon to the database
 * 
 *
 */
@WebServlet("/addCoupon")
public class AddCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCoupon() {
		super();

	}
	
	/**
	 * get the date string from the user and check if it in the right pattern
	 * 
	 * @param expDate
	 * @return the correct time stamp or null in case it was not good
	 */
	private Timestamp parseTime(String expDate) {
		String afterDotString = ".0";
		String newExpDate = expDate.concat(afterDotString);
		Date parsedDate;
		Timestamp timestamp = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss.SSS");
			parsedDate = dateFormat.parse(newExpDate);
			timestamp = new Timestamp(parsedDate.getTime());
			return timestamp;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * validate that the admin is logged in
	 * dispatch to the add coupon view
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = (String) request.getSession()
				.getAttribute("userName");
		if (userName == null) {
			response.sendRedirect("login");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/addCoupon.jsp").forward(request,
				response);
	}


	/**
	 * add the new coupon to the data base
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get the parameters from the user
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		String xString = request.getParameter("x");
		String yString = request.getParameter("y");
		String expDate = request.getParameter("expDate");
		String priceString = request.getParameter("price");

		// parse the date string
		Timestamp timestamp = parseTime(expDate);
		if (timestamp == null) {
			request.getRequestDispatcher("/WEB-INF/addCoupon.jsp").forward(
					request, response);
			return;
		}
		// create new coupon and add it to the database
		Coupon coupon = new Coupon(1, name, description, category,
				Double.parseDouble(xString), Double.parseDouble(yString),
				timestamp, Double.parseDouble(priceString));
		try {
			HibernateCouponsDAO.getInstance().addCoupon(coupon);
			response.sendRedirect("adminProducts");
		} catch (CouponException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
