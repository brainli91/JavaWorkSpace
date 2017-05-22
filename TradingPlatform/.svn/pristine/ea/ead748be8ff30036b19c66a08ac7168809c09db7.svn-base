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

<title>Sell Request - TP</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">
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
						<li><a href="shareholderindex.jsp"><i class="fa fa-fw fa-user"></i> Profile</a>
						</li>
						<li class="divider"></li>
						<li><a href="front.jsp"><i class="log-off"></i> Log Out</a>
						</li>
					</ul>
				</li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="shareholderindex.jsp"><i
							class="ViewProfile"></i> View Profile</a></li>
					<li><a href="editprofile.jsp"><i
							class="EditProfile"></i> Edit Profile</a></li>
					<li><a href="viewportfolio"><i class="View Portfolio"></i> View Portfolio</a></li>
					<li><a href="buyrequest.jsp"><i class="Send Buy Request"></i>
							Send Buy Request</a></li>
					<li class="active"><a href="sellrequest.jsp"><i class="Send Sell Request"></i>
							Send Sell Request</a></li>
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
						<h1 class="page-header">Send Sell Request</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a
								href="shareholderindex.jsp">Dashboard</a></li>
							<li class="active"><i class="fa fa-edit"></i>Send Sell Request</li>
						</ol>
					</div>
				</div>
				<br />
				<!-- /.row -->

				<div class="row">
					<h4> ${ sendsellmsg}</h4>
					<form  method="post" action="sellrequest">
						<div class="col-lg-4 col-lg-offset-4 text-center col-centered">
		
							<div class="form-group input-group">
								<span class="input-group-addon">&nbsp&nbsp&nbsp&nbsp&nbsp&nbspUser Name&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span> <input
									type="text" class="form-control" value="${sessionScope.user.userName}"
									name="username" readonly="readonly">
							</div>
							
							<div class="form-group input-group">
								<span class="input-group-addon">&nbsp&nbspCompany Name&nbsp&nbsp</span> <input
									type="text" class="form-control"
									placeholder="Enter Company Name " name="companyname" required>
							</div>
								<h4>${ nomatchcompany}</h4>
							
							<div class="form-group input-group">
								<span class="input-group-addon">Number of Shares</span> <input
									type="text" class="form-control"
									placeholder="Enter Number of Selling Shares" name="numshare" required>
							</div>

							<div>
								<button type="submit" class="btn btn-success">Enter</button>
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