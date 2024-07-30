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
    <form:form action="saveuser" modelAttribute="user">
    enter name : <form:input path="name"/>
    enter email : <form:input path="email"/>
    enter password : <form:input path="password"/>
    enter mobilenumber : <form:input path="mobilenumber"/>
    <input type="submit">
    </form:form>
</body>
</html>