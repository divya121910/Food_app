<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 style="color:red"> ${message} </h1>
<form action="validateuser" method="post">
enter email: <input type="email" name="email"> <br>
enter password : <input type="password" name="password"> <br>
<input type="submit">
</form>
</body>
</html>