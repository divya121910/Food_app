<%@page import="com.jsp.foodapp.entities.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Item i = (Item) request.getAttribute("itemobj");
	%>

<form:form action="additemtofoodorder" modelAttribute="itemobj">
Name : <form:input path="name" value="<%= i.getName() %>" readonly="true" />
Type :  <form:input path="type" value="<%= i.getType() %>"  readonly="true"/>
Cost : <form:input path="cost" value="<%= i.getCost()%>" readonly="true" />
Quantity : <form:input path="quantity" />
<input type="submit">	
	</form:form>

</body>
</html>