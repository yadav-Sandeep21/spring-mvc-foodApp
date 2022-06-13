<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Create Menus</h1>
<form:form action="menusaved" modelAttribute="menus">
Name:<form:input path="name"/>
Description:<form:input path="description"/>
Cost:<form:input path="cost"/>
Type:<form:input path="type"/>
Offer:<form:input path="offer"/>
Image:<form:input path="image"/>
  <form:button>Save</form:button>



</form:form>
</body>
</html>