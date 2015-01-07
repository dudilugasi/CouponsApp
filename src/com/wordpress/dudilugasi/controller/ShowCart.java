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
import com.wordpress.dudilugasi.model.ShoppingCart;
import com.wordpress.dudilugasi.model.ShoppingCartLine;

/**
 * 
 * show cart servlet
 *
 */
@WebServlet("/showCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowCart() {
		super();

	}

	/**
	 * if the expiration date of the coupon is passed remove the line from the
	 * cart
	 * 
	 * @param cart
	 */
	private void filterExpDate(ShoppingCart cart) {
		List<ShoppingCartLine> lines = cart.getLines();
		for (int i = 0; i < lines.size(); i++) {
			ShoppingCartLine line = lines.get(i);
			Coupon coupon = line.getCoupon();
			if (coupon.getExpDate().before(new Date())) {
				cart.removeLine(coupon);
			}
		}
	}

	/**
	 * get the cart from session and filter the dates and transfer to the show
	 * cart view
	 *
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute(
				"cart");
		if (cart != null) {
			filterExpDate(cart);
		} else {
			request.getSession().setAttribute("cart", new ShoppingCart());
		}
		request.getSession().setAttribute("cart", cart);
		request.getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp")
				.forward(request, response);
	}

}
