package com.wordpress.dudilugasi.model;

public class ShoppingCartLine {
	private Coupon coupon;
	private int quantity;
	
	public ShoppingCartLine(Coupon coupon, int quantity) {
		super();
		this.coupon = coupon;
		this.quantity = quantity;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void addToQuantity() {
		quantity++;
	}
	
	public double getTotal() {
		return this.coupon.getPrice() * this.quantity;
	}
	
	
}
