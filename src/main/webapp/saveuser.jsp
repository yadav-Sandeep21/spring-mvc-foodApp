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
<h1> Create User</h1>
<form:form action="usersaved" modelAttribute="myUser">
Name:<form:input path="name"/>
Email:<form:input path="email"/>
Phone:<form:input path="phone"/>
Password:<form:input path="password"/>
  <form:button>Save</form:button>



</form:form>

</body>
</html>