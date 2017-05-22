<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="static/css/userpage_css.css">
<title>User Page</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div id="wrapper">
	<jsp:include page="sidebar.jsp"></jsp:include>
    <div id="main-wrapper" class="col-md-11 pull-right">
    	<div id="main">
        	
            	<!-- main content goes here -->
            	<main>
	<section>
		<table class="table table-striped table-bordered">

			<thead>
				<tr>
					<th>User Logs</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userlog}" var="line">
					<tr>
						<td>${line}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</section>
	</main>
            </div>
	<jsp:include page="footer.jsp"></jsp:include>          
        </div>
</div>

</body>
</html>
