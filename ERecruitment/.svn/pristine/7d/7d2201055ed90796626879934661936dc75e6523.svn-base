<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href='https://fonts.googleapis.com/css?family=Josefin+Slab:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"> -->
<jsp:include page="common/head.jsp"></jsp:include>
<script>$(function(){
	$("#usersTable").dataTable();
})</script>
<link rel="stylesheet" type="text/css"
	href="static/css/userpage_css.css">
<title>Blocked User</title>
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
		<!-- Your Main Body Content goes here -->
		<!-- If you want to change the position of the main(which contains the content) then create a new user_head.jsp and new css for it and just reposition main
		but just copy and paste the original user_head.jsp, and user_page_css.css -->
		<table id="usersTable" class="table table-striped table-bordered display">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${blockedUsers}" var="blockedUser">
					<tr>
						<td>${blockedUser.firstName}</td>
						<td>${blockedUser.lastName}</td>
						<td>${blockedUser.email}</td>
						<td>${blockedUser.role.name}</td>
											
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