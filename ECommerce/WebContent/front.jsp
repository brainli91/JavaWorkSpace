<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ECommerce</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
	
<link rel="stylesheet" href="css/layout.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/myjs.js"></script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" rel="home" href="#"
					title="Trading Platform Logo"> <img
					style="max-width: 100px; margin-top: -12px;" src="img/tplogo.png">
				</a> <a class="navbar-brand" href="#home">ECommerce</a>


			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">




					<li><button type="button" class="btn btn-info navbar-btn"
							data-toggle="modal" data-target="#myModal">
							<span class="glyphicon glyphicon-log-in"></span> Log In
						</button></li>
				</ul>
			</div>
		</div>
	</nav>

	<br />
	<br />
						<h5>${loginfailure}</h5>
	<br />

	
	<!-- Login Window -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" >
			<form role="form" method="post" action="login">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">Log in</h4>
				</div>

				<div class="modal-body">
					
						<div class="form-group">
							<div class="input-group">
								<input type="text" class="form-control" id="uLogin"
									placeholder="Login" name ="username"> <label for="uLogin"
									class="input-group-addon glyphicon glyphicon-user"></label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="input-group">
								<input type="password" class="form-control" id="uPassword"
									placeholder="Password" name ="password"> <label for="uPassword"
									class="input-group-addon glyphicon glyphicon-lock"></label>
							</div>
						</div>

						<div class="checkbox">
							<label> <input type="checkbox"> Remember me
							</label>
						</div>
					

				</div>

				<div class="modal-footer">
					<input type = "submit" class="form-control btn btn-primary" value ="Log In"></input>

					<div class="progress">
						<div class="progress-bar progress-bar-primary" role="progressbar"
							aria-valuenow="1" aria-valuemin="1" aria-valuemax="10	0"
							style="width: 0%;">
							<span class="sr-only">progress</span>
						</div>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</body>
</html>