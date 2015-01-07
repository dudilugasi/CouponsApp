package com.wordpress.dudilugasi.controller;

import java.io.IOException;
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

@WebServlet("/products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *  if the expiration date of the coupon is passed remove it from the list
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	private void filterExpDate(HttpServletRequest request) {
		List<Coupon> list = (List<Coupon>) request.getAttribute("list");

		for (int i = 0; i < list.size(); i++) {
			Coupon coupon = list.get(i);
			if (coupon.getExpDate().before(new Date())) {
				list.remove(i);
			}
		}
	}

	public Products() {
		super();

	}

	/**
	 * transfer to the choose category view if the category was not chosen
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/chooseCategory.jsp").forward(
				request, response);
	}

	
	/**
	 *  display the view of the products according the category chosen
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get the category from the the user
		String category = request.getParameter("category");

		// if the user did not chose category send him to chose one
		if (category == null) {
			request.getRequestDispatcher("/WEB-INF/chooseCategory.jsp")
					.forward(request, response);
		} else {
			try {
				// get list of coupons from database
				List<Coupon> list = HibernateCouponsDAO.getInstance()
						.getCouponsByCategory(category);
				// set attribute to the request
				request.setAttribute("list", list);
				filterExpDate(request);
				
				// dispatch to the products view
				request.getRequestDispatcher("/WEB-INF/showProducts.jsp")
						.forward(request, response);
			} catch (CouponException e) {
				e.printStackTrace();
			}
		}
	}

}
