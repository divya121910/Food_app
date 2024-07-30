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
<form:form action="saveproduct" modelAttribute="Product">
enter name : <form:input path="name"/>
enter type : <form:input path="type"/>
enter cost : <form:input path="cost"/>

<input type="submit">
</form:form>
</body>
</html>