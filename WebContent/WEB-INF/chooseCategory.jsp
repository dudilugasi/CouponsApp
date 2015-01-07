<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
    choose category: 
	<form method="post" action="products">
		<select name="category">
			<option value="food">food</option>
			<option value="electronics">electronics</option>
			<option value="spa">spa</option>
			<option value="holiday">holiday</option>
		</select>
		<input type="submit" value="next" />
	</form>
</body>
</html>