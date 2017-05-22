<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<style type ="text/css">
	.error{
		color:red;
	}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>

	<h1 class ="error"> ${errorMsg}</h1>
	<form method="post" action="login">
	Username:<input type="text" name ="username"><br/>
	Password:<input type="password" name ="password"><br/>
	<input type="submit" value="login">
	</form>
	
	<p>
	There are 
	<c:if test="${empty userCount}" >0</c:if>
	<c:if test="${not empty userCount}" > ${userCount} </c:if>
	User(s) online
	</p>

</body>
</html>