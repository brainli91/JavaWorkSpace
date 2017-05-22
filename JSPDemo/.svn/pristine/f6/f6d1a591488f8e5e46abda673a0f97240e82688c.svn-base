<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Day</title>
</head>
<body>

	<%
		int dayOfWeek = (int)request.getAttribute("dayOfWeek");
	
	%>
	<%-- <p> Today is <strong><%= dayOfWeek %> 
		<%
			switch(dayOfWeek) {
			case 1:
					out.print("st");
			break;
			case 2:
				out.print("nd");
			break;
			case 3:
				out.print("rd");
			break;
			default:
				out.print("th");
			
		
			}
		%>
		</strong> day of the week
	</p> --%>
	
	<p>Today is ${requestScope.dayOfWeek}
		<strong>
		<c:choose>
			<c:when test="${dayOfWeek == 1}">st</c:when>
			<c:when test="${dayOfWeek == 2}">nd</c:when>
			<c:when test="${dayOfWeek == 3}">rd</c:when>
			<c:otherwise>th</c:otherwise>
		</c:choose>
		</strong>day of the week
	</p>
	<br/>
	
	<ul>
		<c:forEach items="${countries}" var="country">
			<li>${country}</li>
		</c:forEach>

	</ul>
	<br/>
	
	<c:forEach begin="1" end="50" step="2" var="i">
		${i},&nbsp;
	</c:forEach>
	<br/>
	
	<c:forTokens items="Peter,George,Sammy,Nazia,Jun,Jacky" delims="," var="name">
		<%-- ${name},&nbsp; --%>
		<c:out value="${name},"/>
	</c:forTokens>
	<br/>
	
	<c:forEach items="${names}" var="name">
		<p>${name.key} --> ${name.value}</p>
	</c:forEach>

	
	



	
</body>

</html>