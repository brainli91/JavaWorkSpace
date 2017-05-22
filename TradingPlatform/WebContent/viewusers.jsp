<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>View Users - TP</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css" />
<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<script type="text/javascript" src="js/myjs.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<script type="text/javascript"
	src="https://cdn.datatables.net/r/bs-3.3.5/jqc-1.11.3,dt-1.10.8/datatables.min.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>

</head>
<body>

	<div id="wrapper">

<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="adminindex.jsp">Trading Platform</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> ${sessionScope.user.firstName} ${user.lastName} <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="adminindex.jsp"><i class="fa fa-fw fa-user"></i> Profile</a>
						</li>
						<li class="divider"></li>
						<li><a href="front.jsp"><i class="log-off"></i> Log Out</a>
						</li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li ><a href="adminindex.jsp"><i
							class="DashBoard"></i> Dashboard</a></li>
					<li><a href="adduser.jsp"><i class="Add User"></i> Add
							User</a></li>
					<li><a href="removeuser.jsp"><i class="Remove User"></i>
							Remove User</a></li>
					<li><a href="updateuser.jsp"><i class="Update User"></i>
							Update User</a></li>
					<li class="active"><a href="showusers"><i class="View Users"></i>
							View All Users</a></li>
					<li><a href="viewuserlog.jsp"><i
							class="fa fa-fw fa-wrench"></i> View User Log</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>


		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">View All Users</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a
								href="adminindex.jsp">Dashboard</a></li>
							<li class="active"><i class="fa fa-edit"></i>View All Users</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-body">
								
									<table
									id="example" class="display table table-bordered table-hover table-striped text" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>User ID</th>
												<th>User Name</th>
												<th>First Name</th>
												<th>Last Name</th>
												
												<th>Edit</th>
												<th>Remove</th>
											</tr>
										</thead>
										<tbody>
					
										<c:forEach items="${users}" var="user">
											<tr>
							
												<td>${user.id}</td>
												<td>${user.userName}</td>

												<td>${user.firstName}</td>
												<td>${user.lastName}</td>

 												<td><a onclick="editUser('${user.id}','${user.userName}','${user.passWord}','${user.firstName}', '${user.lastName}');" href="#" ><img height="16" width="16"  align="bottom" src = img/edit.png></a></td> 
												
												<td><a href = "userManager?id=${user.id}&amp;operation=delete"><img height="16" width="16"  align="bottom" src = img/delete.png></a></td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>

								
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->
		
		</div>
</div>
	<!-- /#wrapper -->
</div>

	<div id="overlay">
<form role="form">
						<div class="col-lg-4 text-center col-centered">

							<div class="form-group input-group">
								<span class="input-group-addon">User Name</span> <input
									type="text" class="form-control" placeholder=" Enter Username"
									id="usr">
							</div>

							<div class="form-group input-group">
								<span class="input-group-addon">First Name</span> <input
									type="text" class="form-control"
									placeholder="Enter New Given Name">
							</div>

							<div class="form-group input-group">
								<span class="input-group-addon">Last Name</span> <input
									type="text" class="form-control"
									placeholder="Enter Family Name">
							</div>

							<div class="form-group input-group">
								<span class="input-group-addon">Password &nbsp</span> <input
									type="password" class="form-control"
									placeholder="Enter New Password" id="pwd">
							</div>

							<div class="dropdown form-group input-group">

								<button class="btn-xlarge btn-primary dropdown-toggle"
									type="button" data-toggle="dropdown">
									Role <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><input type="checkbox" value="1" id="menuCheckbox1"
										class="roleCheckBox" name="administrator">
										Administrator</li>
									<li><input type="checkbox" value="2" id="menuCheckbox2"
										class="roleCheckBox" name="shareholder"> Shareholder</li>
									<li><input type="checkbox" value="3" id="menuCheckbox4"
										class="roleCheckBox" name="broker"> Broker</li>

								</ul>
							</div>

							<div class='buttons'>
								<button type="submit" class="btn btn-success">Submit</button>
								<button type="reset" class="btn btn-info">Reset</button>
							</div>

						</div>
					</form>
          		

			
			





</div>
<script type="text/javascript">
		// For demo to fit into DataTables site builder...
		$('#example').removeClass('display').addClass(
				'table table-striped table-bordered');
</script>
</body>
</html>