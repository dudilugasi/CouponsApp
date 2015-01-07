<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>update coupon</title>
</head>
<body>
    <nav> 
       <a href="index.html">home</a>
       <a href="adminProducts">view products</a>
    </nav>
	<form method="post" action="updateCoupon">
		name: <input type="text" name="name" value="${ couponToEdit.name }" /><br />
		description: <input type="text" name="description" value="${ couponToEdit.description }" /><br /> 
		category: 
		<select name="category">
			<option value="food">food</option>
			<option value="electronics">electronics</option>
			<option value="spa">spa</option>
			<option value="holiday">holiday</option>
		</select><br />
		longitude: <input type="number" name="x" value="${ couponToEdit.x }"><br />
		latitude: <input type="number" name="y" value="${ couponToEdit.y }"><br />
		price: <input type="number" name="price" value="${ couponToEdit.price }"><br />
		expiration date: <input type="text" name="expDate" value="${ couponToEdit.expDate }"><br />
		<input type="hidden" name="id" value="${ couponToEdit.id }">
		<input type="submit" value="submit">
	</form>
</body>
</html>