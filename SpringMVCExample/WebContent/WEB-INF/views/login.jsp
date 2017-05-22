<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type = "text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h2 class="error">${errorMsg}</h2>
	<sf:form method ="post" action = "processLogin" modelAttribute="user">
		<sf:errors path="username" element="div" cssClass= "error"/> 
		<sf:label path="username">Username:</sf:label>
		<sf:input path="username"/><br/>
		
		<sf:errors path="password" element="div" cssClass= "error"/> 
		<sf:label path="password">Password:</sf:label>
		<sf:password path="password"/><br/>
		
		<sf:select path="interests" mutiple="mutiple">
			<sf:option value="Music">Music</sf:option>
			<sf:option value="Sports">Sports</sf:option>
			<sf:option value="Games">Games</sf:option>
		</sf:select>

		
		<input type ="submit" value="login">
	</sf:form>
</body>
</html>