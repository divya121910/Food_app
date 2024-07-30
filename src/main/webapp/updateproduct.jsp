<%@page import="com.jsp.foodapp.entities.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  Product product = (Product) request.getAttribute("productdata") ; %>

<form action="updateprod" method="post">
enter id : <input type="number" name="id" value= <%= product.getId() %> readonly="true" >  <br>
enter name : <input type="text" name="name" value=<%= product.getName() %>>   <br>
enter type : <input type="text" name="type" value=<%= product.getType()%>>     <br>
enter cost : <input type="number" name="cost" value=<%= product.getCost() %>>   <br>
<input type="submit">
</form>

</body>
</html>