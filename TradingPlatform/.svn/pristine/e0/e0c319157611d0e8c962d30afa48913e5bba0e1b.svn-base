<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Shareholder Dashboard - TP</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">


<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

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
				<a class="navbar-brand" href="shareholderindex.jsp">Trading Platform</a>
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
			
			<!--"1....View My Profile\n2....Change My Profile \n3....View My Portfolio\n4....Send Request \n5....View History of Request \n6....View History of Trades\n0....Logout"-->
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="shareholderindex.jsp"><i
							class="ViewProfile"></i> View Profile</a></li>
					<li  class="active"><a href="editprofile.jsp"><i
							class="EditProfile"></i> Edit Profile</a></li>
					<li><a href="viewportfolio"><i class="View Portfolio"></i> View Portfolio</a></li>
					<li><a href="buyrequest.jsp"><i class="Send Request"></i>
							Send Request</a></li>
					<li><a href="updateuser.jsp"><i class="Update User"></i>
							View History of Request</a></li>
					<li><a href="showusers"><i class="View Users"></i>
							View History of Trades</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Edit Profile</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a
								href="shareholderindexindex.jsp">Dashboard</a></li>
							<li class="active"><i class="fa fa-edit"></i> Edit Profile</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<h4>${usernotexist} </h4>
					<br/>
					<form role="form" method="post" action="editprofile">
						<div class="col-lg-4 text-center col-centered">

							<div class="form-group input-group">
								<span class="input-group-addon">User Name</span> <input
									type="text" class="form-control" value="${sessionScope.user.userName}"
									name="username" readonly="readonly">
							</div>

							<div class="form-group input-group">
								<span class="input-group-addon">First Name</span> <input
									type="text" class="form-control"
									placeholder="Enter New Given Name" name="firstname" required>
							</div>

							<div class="form-group input-group">
								<span class="input-group-addon">Last Name</span> <input
									type="text" class="form-control"
									placeholder="Enter Family Name" name="lastname" required>
							</div>

							<div class="form-group input-group">
								<span class="input-group-addon">Password &nbsp</span> <input
									type="password" class="form-control"
									placeholder="Enter New Password" name="password" required>
							</div>

							<div class="dropdown form-group input-group">

								<button class="btn-xlarge btn-primary dropdown-toggle"
									type="button" data-toggle="dropdown">
									Role <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><input type="checkbox" value="1" id="menuCheckbox1"
										class="roleCheckBox" name="administrator" >
										Administrator</li>
									<li><input type="checkbox" value="2" id="menuCheckbox2"
										class="roleCheckBox" name="shareholder" > Shareholder</li>
									<li><input type="checkbox" value="3" id="menuCheckbox4"
										class="roleCheckBox" name="broker" > Broker</li>

								</ul>
							</div>

							<div class='buttons'>
								<button type="submit" class="btn btn-success">Submit</button>
								<button type="reset" class="btn btn-info">Reset</button>
							</div>

						</div>
					</form>
				</div>

			</div>
			<!-- /.row -->

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->




</body>

</html>