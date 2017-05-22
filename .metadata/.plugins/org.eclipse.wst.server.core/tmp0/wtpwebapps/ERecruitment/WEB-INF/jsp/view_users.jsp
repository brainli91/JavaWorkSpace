<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="static/css/userpage_css.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="static/css/errorPage_css.css">
<script>$(function(){
	$("#usersTable").dataTable();
})</script> 

<script>$(function(){
	$("#inactiveTable").dataTable();
})</script> 
<script>$(function(){
	$("#blockedTable").dataTable();
})</script> 

<style type="text/css">
#create-user-button{position: relative; left: 94%}
</style>
<title>Users</title>
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
	<c:if test="${not empty successMsg}">
			<div class="success alert alert-success">
				<div class="glyphicon glyphicon-ok">&nbsp;${successMsg}</div>
			</div>

	 </c:if>
		<%-- <h2 style="color:green">${successMsg}</h2> --%>
		<h2>Active Unblocked Users</h2>
		<a href="createUser"><button id="create-user-button" type="button" class="btn btn-secondary">Add User</button></a>
		<table id="usersTable" class="table table-striped table-bordered display">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Active</th>
					<th>Blocked</th>
					<th>Edit</th>
					<th>Deactivate</th>
					<th>Block User</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${users}" var="user">
				<c:if test="${user.active eq true}">
				<c:if test="${user.blocked eq false}">

				<c:if test="${sessionScope.user.email ne user.email}">

				<c:if test="${user.email ne sessionScope.user.email}">

					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.role.name}</td>
						<c:if test="${user.active eq false}">
						<td><span class="glyphicon glyphicon-remove"></span></td>
						</c:if>
						<c:if test="${user.active eq true}">
						<td><span class="glyphicon glyphicon-ok"></span></td>
						</c:if>
						
						<c:if test="${user.blocked eq false}">
						<td><span class="glyphicon glyphicon-remove"></span></td>
						</c:if>
						
						<c:if test="${user.blocked eq true}">
						<td><span class="glyphicon glyphicon-ok"></span></td>
						</c:if>
						<td align="center"><a type="btn" href="editUser?id=${user.id}"><span
								class="glyphicon glyphicon-pencil"></span>
						</a></td>
						
						<c:if test="${user.active eq false}">
						<td align="center"><span class="glyphicon glyphicon-trash"></span>	
						</td>
						</c:if>
						<c:if test="${user.active eq true}">
						<td align="center"><a href="removeUser?id=${user.id}"><span
								class="glyphicon glyphicon-trash"></span>
						</a></td>
						</c:if> 
						
						<c:if test="${user.blocked eq true}">
						<td align="center"><span
								class="glyphicon glyphicon-ban-circle"></span>
						</td>
						</c:if>
						<c:if test="${user.blocked eq false}">
						<td align="center"><a href="blockUser?id=${user.id}"><span class="glyphicon glyphicon-ban-circle"></span></a></td>
						</c:if>
						</tr>
				</c:if>
				</c:if>
				</c:if>
						</c:if>

				</c:forEach>

			</tbody>
		</table>
		<br/>
		<hr>
		<br/>
		<h2>Inactive Users</h2>
		<table id="inactiveTable" class="table table-striped table-bordered display">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Blocked</th>
					<th>Reactivate</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${users}" var="user">
					<c:if test="${user.active eq false}">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.role.name}</td>
						
						<c:if test="${user.blocked eq false}"><td align="center"><span class="glyphicon glyphicon-remove"></span></td></c:if>
						<c:if test="${user.blocked eq true}"><td align="center"><span class="glyphicon glyphicon-ok"></span></td></c:if>
						
						
						<c:if test="${user.active eq false}"><td align="center"><a href="reactivateUser?id=${user.id}"><span class="glyphicon glyphicon-plus"></span></a></td></c:if>
					</tr>
					</c:if>
				</c:forEach>

			</tbody>
		
		</table>
		<br/>
		<hr>
		<br/>
		<h2>Blocked Users</h2>
		<table id="blockedTable" class="table table-striped table-bordered display">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Active</th>
					<th>Unblock</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${users}" var="user">
					<c:if test="${user.blocked eq true}">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.role.name}</td>
						
						<c:if test="${user.active eq false}"><td align="center"><span class="glyphicon glyphicon-remove"></span></td></c:if>
						<c:if test="${user.active eq true}"><td align="center"><span class="glyphicon glyphicon-ok"></span></td></c:if>
						
						
						<c:if test="${user.blocked eq true}"><td align="center"><a href="unblockUser?id=${user.id}"><span class="glyphicon glyphicon-plus"></span></a></td></c:if>
					</tr>
					</c:if>
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