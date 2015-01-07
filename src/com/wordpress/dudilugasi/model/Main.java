package com.wordpress.dudilugasi.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
	
	private static Timestamp parseTime(String expDate) {
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

    public static void main(String[] args) {
    	
    	String expDate = "2013-02-12 00:00:00";
    	Timestamp timestamp = parseTime(expDate);
		System.out.println(timestamp);
		Coupon coupon = new Coupon(1,"name","descripntion","category",2,2,timestamp,2);
		try {
			HibernateCouponsDAO.getInstance().addCoupon(coupon);
		} catch (CouponException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
