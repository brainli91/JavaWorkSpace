<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>	
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/registerlayout.css">
	<link rel="stylesheet" href="http://www.mydomain.com/assets/css/main.css">
	<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/myjs.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.js"></script>
	<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<title>Registration - TP</title>	
</head>

<body>

		<div class="container registerbackground">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Trading Platform - Registration</h1>
	               		<hr/>
	               	</div>
	            </div> 
				<div class="main-login main-center">
				
				<h5>${createfailed}</h5>
					<form class="form-horizontal" method="post" action="register">
						
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username" required/>
								</div>
							</div>
						</div>
						<h5>${userexistmsg}</h5>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">First Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="firstname" id="name"  placeholder="Enter your Given Name" required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Last Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="lastname" id="name"  placeholder="Enter your Family Name" required />
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" required/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirmpassword" id="confirm"  placeholder="Confirm your Password" required/>
								</div>
							</div>
						</div>
						<h5>${nonmatchingpassword}</h5>
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

						<div class="form-group ">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
						<div class="login-register">
				            <a href="front.jsp">Login</a>
				         </div>
					</form>
				</div>
			</div>
		</div>

		
	</body>
</html>