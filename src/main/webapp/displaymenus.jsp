<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Description</th>
<th>Cost</th>
<th>Type</th>
<th>Offer</th>
<th>Image</th>
<th>Place Order</th>

</tr>
<c:forEach var="item" items="${menusaved}">
<tr>
<td>${item.getId()}</td>
<td>${item.getName()}</td>
<td>${item.getDescription()}</td>
<td>${item.getCost()}</td>
<td>${item.getType()}</td>
<td>${item.getOffer()}</td>
<td>${item.getImage()}</td>
<td> <a href="quantity.jsp?id=${item.getId()}">Add Order</a> </td>
</tr>
</c:forEach>
</table>

</body>
</html>