package com.wordpress.dudilugasi.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.wordpress.dudilugasi.model.Coupon;

public class ShoppingCart {
	private Map<Coupon, ShoppingCartLine> linesMap = new Hashtable<Coupon, ShoppingCartLine>();
	
	public ShoppingCart() {}

	public void addCoupon(Coupon coupon) {
		if (linesMap.containsKey(coupon)) {
			linesMap.get(coupon).addToQuantity();
		} else {
			linesMap.put(coupon, new ShoppingCartLine(coupon, 1));
		}
	}
	
	public void removeLine(Coupon coupon) {
		linesMap.remove(coupon);
	}

	public List<ShoppingCartLine> getLines() {
		return new ArrayList<ShoppingCartLine>(linesMap.values());
	}
	
	public double getTotal() {
		Collection<ShoppingCartLine> shoppingCartLines = this.linesMap.values();
		double total = 0;
		Iterator<ShoppingCartLine> iterator = shoppingCartLines.iterator();
		while (iterator.hasNext()) {
			ShoppingCartLine line = iterator.next();
			total += (line.getQuantity() * line.getCoupon().getPrice());
		}
		return total;
	}
}
