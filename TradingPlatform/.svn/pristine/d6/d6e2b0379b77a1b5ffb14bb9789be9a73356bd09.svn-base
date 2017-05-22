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
						<li><a href="shareholderindex.jsp"><i class="fa fa-fw fa-user"></i> Profile</a>
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
					<li class="active"><a href="shareholderindex.jsp"><i
							class="ViewProfile"></i> View Profile</a></li>
					<li><a href="editprofile.jsp"><i
							class="EditProfile"></i> Edit Profile</a></li>
					<li><a href="viewportfolio"><i class="View Portfolio"></i> View Portfolio</a></li>
					<li><a href="buyrequest.jsp"><i class="Send Buy Request"></i>
							Send Buy Request</a></li>
					<li><a href="sellrequest.jsp"><i class="Send Sell Request"></i>
							Buy Sell Request</a></li>
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
						<h1 class="page-header">
							Profile <small id ="subtitle">ShareHolder Page</small>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Profile
							</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->






				<div class="row">
					<div class="container">
    			<div class="row">
				    <div class="col-xs-12 col-sm-6 col-md-6">
				            <div class="well well-sm">
				                <div class="row">
				                    <div class="col-sm-6 col-md-4">
				                        <img src="img/profile.png" alt="Profile Picture" class="img-rounded img-responsive" />
				                    </div>
				                    <div class="col-sm-6 col-md-8">
				                        <h4 class="profiletext">${sessionScope.user.firstName} ${user.lastName}</h4>
				                        <small><cite title="Toronto, ON">Toronto, ON <i class="glyphicon glyphicon-map-marker">
				                        </i></cite></small>
				                        <p>
				                            <i class="glyphicon glyphicon-user" title="User Name"></i>${sessionScope.user.userName}
				                            <br />
				                            <i class="glyphicon glyphicon-envelope" title="Email"></i>${sessionScope.user.firstName}.${user.lastName}@fdmgroup.com
				                            <br />
				                            <i class="glyphicon glyphicon-briefcase" title="Roles"></i>Shareholder</a>
				                            <br />
				                        </p>
				                    </div>
				                </div>
				            </div>
				        </div>
				    </div>

							</div>
						</div>



				</div>
			</div>
			<!-- /.row -->

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->




</body>

</html>