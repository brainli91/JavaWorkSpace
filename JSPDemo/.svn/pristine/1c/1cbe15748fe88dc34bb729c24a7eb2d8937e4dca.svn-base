<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>
<body bgcolor="${cookie.bgcolor.value}"> 
	<h1>Welcome ${sessionScope.user.firstName} ${user.lastName} !!!</h1>
	<br/>
	<p>
	There are 
	<c:if test="${empty userCount}" >0</c:if>
	<c:if test="${not empty userCount}" > ${userCount} </c:if>
	User(s) online
	</p>
	
</body>
</html>