<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page errorPage="error.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body>

	<%-- <%!
		public int div(int a, int b){
			return a/b;
		}
	%>
	
	<% 
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		//int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
		//int sum = Integer.parseInt(num1) / Integer.parseInt(num2);
		int sum = div(Integer.parseInt(num1), Integer.parseInt(num2));
	%>
	
	<p>the sum of <%= num1 %> and <%= num2 %> is: <strong><%= sum %></strong></p> --%>
	
	<jsp:useBean id="calculator" class="com.fdmgroup.model.Calculator" scope="page"></jsp:useBean><!--Calculator calculator = new Calculator();-->
	<jsp:setProperty name="calculator" property="a" value="${param.num1}"/> <!--Calculator.setA(35)-->
	<jsp:setProperty name="calculator" property="b" value="${param.num2}"/>
	
	The addition of <jsp:getProperty name="calculator" property="a" /> and <jsp:getProperty name="calculator" property="b" /> is: <strong>${calculator.add()}</strong><br/>
	The subtraction of <jsp:getProperty name="calculator" property="a" /> and <jsp:getProperty name="calculator" property="b" /> is: <strong>${calculator.sub()}</strong><br/>
	The multiplication of <jsp:getProperty name="calculator" property="a" /> and <jsp:getProperty name="calculator" property="b" /> is: <strong>${calculator.mul()}</strong><br/>
	The division of <jsp:getProperty name="calculator" property="a" /> and <jsp:getProperty name="calculator" property="b" /> is: <strong>${calculator.divide()}</strong><br/>
	
</body>
</html>