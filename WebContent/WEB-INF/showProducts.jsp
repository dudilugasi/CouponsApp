<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>coupons</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>name</th>
			<th>description</th>
			<th>expiration date</th>
			<th>category</th>
			<th>price</th>
			<th></th>
		</tr>
		<c:forEach items="${ list }" var="coupon">
			<tr>
				<td>${ coupon.name }</td>
				<td>${ coupon.description }</td>
				<td>${ coupon.expDate }</td>
				<td>${ coupon.category }</td>
				<td>${ coupon.price }</td>
				<td><a href="addCouponToCart?id=${ coupon.id }">add</a></td>
			</tr>
		</c:forEach>
		
	</table>
	<p><a href="chooseCategory">choose category</a> <a href="showCart">show cart</a></p>
</body>
</html>