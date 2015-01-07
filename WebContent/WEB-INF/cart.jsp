<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>your coupons</title>
</head>
<body>
	<table border='1'>
		<tr>
			<th>name</th>
			<th>description</th>
			<th>expiration date</th>
			<th>category</th>
			<th>price</th>
			<th>quantity</th>
			<th>total</th>
		</tr>
		<c:forEach items="${ cart.lines }" var="line">
			<tr>
				<td>${ line.coupon.name }</td>
				<td>${ line.coupon.description }</td>
				<td>${ line.coupon.expDate }</td>
				<td>${ line.coupon.category }</td>
				<td>${ line.coupon.price }</td>
				<td>${ line.quantity }</td>
				<td>${ line.total }</td>
			</tr>
		</c:forEach>
	</table>
	<p>total : ${ cart.total }</p>
	<p> <a href="products">show products</a>
</body>
</html>