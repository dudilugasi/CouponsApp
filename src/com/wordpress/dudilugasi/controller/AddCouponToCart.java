package com.wordpress.dudilugasi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wordpress.dudilugasi.model.CouponException;
import com.wordpress.dudilugasi.model.HibernateCouponsDAO;
import com.wordpress.dudilugasi.model.ShoppingCart;

@WebServlet("/addCouponToCart")
public class AddCouponToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCouponToCart() {
		super();

	}
	
	/**
	 *  get an id from the user and adds the coupon to the cart
	 *  if no cart exist it will create one
	 *  transfer to show cart page
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productID = (String)request.getParameter("id");
		if (productID != null) {
			HttpSession session = request.getSession();
			if (session.getAttribute("cart") == null) {
				session.setAttribute("cart", new ShoppingCart());
			}
			ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
			try {
				cart.addCoupon(HibernateCouponsDAO.getInstance().getCoupon(Integer.parseInt(productID)));
				response.sendRedirect("showCart");
			} catch (NumberFormatException | CouponException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
