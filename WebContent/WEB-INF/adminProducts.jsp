<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>products</title>
</head>
<body>
	<h1>Welcome ${ userName }</h1>
	<h2>products</h2>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>description</th>
			<th>expDate</th>
			<th>category</th>
			<th>longitude</th>
			<th>latitude</th>
			<th>price</th>
			<th>action</th>
		</tr>
		<c:forEach items="${ couponsList }" var="coupon">
			<tr>
				<td>${ coupon.id }</td>
				<td>${ coupon.name }</td>
				<td>${ coupon.description }</td>
				<td>${ coupon.category }</td>
				<td>${ coupon.expDate }</td>
				<td>${ coupon.x }</td>
				<td>${ coupon.y }</td>
				<td>${ coupon.price }</td>
				<td><a href="updateCoupon?id=${ coupon.id }">update</a>|<a
					href="deleteCoupon?id=${ coupon.id }">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="addCoupon">add coupon</a> <a href="logout">log out</a>
	</p>

</body>
</html>