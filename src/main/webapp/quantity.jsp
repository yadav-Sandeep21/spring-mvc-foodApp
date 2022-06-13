<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String menuId = request.getParameter("id");
	session.setAttribute("menuid", menuId);
	%>
	<form action="item">
		Add Quantity: <input type="number" name="quantity"> <br>
		<br> Enter userId: <input type="number" name="userId"> <br>
		<br> <input type="submit" name="add" value="Place Order">
                 <a href="addmore">Add More Items</a>
	</form>
</body>
</html>