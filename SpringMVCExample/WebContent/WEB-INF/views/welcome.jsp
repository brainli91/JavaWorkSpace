<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<h1>Hello ${sessionScope.user.firstname}${sessionScope.user.lastname} !!!!</h1>
	
	<br/>
	<br/>
	<p>The sum is :${sum}</p>
	
	<ul>
		<c:forEach items="${user.interests}" var ="interest">
			<h2>${interest}</h2>
		</c:forEach>
	</ul>
</body>
</html>