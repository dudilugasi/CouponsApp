package com.wordpress.dudilugasi.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wordpress.dudilugasi.model.Coupon;
import com.wordpress.dudilugasi.model.CouponException;
import com.wordpress.dudilugasi.model.HibernateCouponsDAO;

@WebServlet("/updateCoupon")
public class UpdateCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCoupon() {
		super();

	}

	/**
	 * 
	 * @param id
	 *            of the wanted coupon
	 * @return coupon or null if coupon was mot found
	 */
	@SuppressWarnings("unchecked")
	private Coupon getCouponFromList(int id) {
		List<Coupon> list = (List<Coupon>) getServletContext().getAttribute(
				"couponsList");
		for (Coupon coupon : list) {
			if (coupon.getId() == id) {
				return coupon;
			}
		}
		return null;

	}

	/**
	 * send the administrator to the update coupon view according to the id
	 * Received in parameter
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = (String) request.getSession()
				.getAttribute("userName");
		if (userName == null) {
			response.sendRedirect("login");
			return;
		}
		String id = request.getParameter("id");
		if (id == null || id.trim().length() == 0) {
			response.sendRedirect("adminProducts");
			return;
		}
		Coupon coupon = getCouponFromList(Integer.parseInt(id));
		if (coupon != null) {
			request.setAttribute("couponToEdit", coupon);
			request.getRequestDispatcher("/WEB-INF/updateCoupon.jsp").forward(
					request, response);
		} else {
			// error
		}
	}

	/**
	 * add the new coupon to the data base
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Receive parameters from the form
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		String xString = request.getParameter("x");
		String yString = request.getParameter("y");
		String expDate = request.getParameter("expDate");
		String priceString = request.getParameter("price");
		String id = request.getParameter("id");
		
		// get the coupon we want to edit
		Coupon coupon = getCouponFromList(Integer.parseInt(id));
		
		//date parsing
		Date parsedDate;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss.SSS");
			parsedDate = dateFormat.parse(expDate);
			Timestamp timestamp = new Timestamp(parsedDate.getTime());
			coupon.setExpDate(timestamp);
		} catch (ParseException e) {
			request.getRequestDispatcher("/WEB-INF/updateCoupon.jsp").forward(
					request, response);
			return;
		}
		
		// update the coupon attributes
		coupon.setCategory(category);
		coupon.setDescription(description);
		coupon.setName(name);
		coupon.setX(Double.parseDouble(xString));
		coupon.setY(Double.parseDouble(yString));
		coupon.setPrice(Double.parseDouble(priceString));
		
		//update the database and redirect to the main administrator menu
		try {
			HibernateCouponsDAO.getInstance().updateCoupon(coupon);
			response.sendRedirect("adminProducts");
		} catch (CouponException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
