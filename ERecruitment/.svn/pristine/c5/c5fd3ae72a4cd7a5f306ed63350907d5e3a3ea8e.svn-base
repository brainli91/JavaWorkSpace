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
<script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
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
        <h2>Edit Your Account</h2>
        <br/>

		<div class="container-fluid-full registerBox" align="center">
			<div class="row-fluid">

				<div class="row">
					<div class="login-box">
						<div class="icons">
							<a href=""><i class="halflings-icon home"></i></a>
						</div>
						<sf:form class="form-horizontal" method="post" id="editUserForm"
							action="editCurrentUser" modelAttribute="editUser">
							<fieldset>
								
							
								
								<div class="input-prepend">
									<label>First Name:</label> <span class="add-on"><i
										class="halflings-icon user"></i></span>
									<sf:input class="form-control" path="firstName" id="firstName"
										type="text" placeholder="Enter first name" required="required" />
								</div>


								<div class="input-prepend">
									<label>Last Name:</label> <span class="add-on"><i
										class="halflings-icon user"></i></span>
									<sf:input class="form-control" path="lastName" id="lastName"
										type="text" placeholder="Enter last name" required="required" />
								</div>

								<br />

								<div class="input-prepend" title="Password">
									<label>Password:</label> <span class="add-on"><i
										class="halflings-icon lock"></i></span> 
										
										<input class="form-control"	name="passworda" id="passworda" type="password"
										placeholder="Enter password" />


								</div>

								<div class="input-prepend">
									<label>Confirm Password:</label> <span class="add-on"><i
										class="halflings-icon lock"></i></span> <input class="form-control"
										name="passwordAgain" id="passwordAgain" type="password"
										placeholder="Enter password again" />
								</div>
<br/>


								<div class="button-login">
									<button type="submit" class="btn btn-primary">Submit</button>
									<button type="reset"  class="btn btn-danger" onclick="history.back()">Cancel</button>
								</div>
							</fieldset>
						</sf:form>

						<script>
						$("#editUserForm").validate({
					           rules: {
					               passworda: { 
					                 required: false,
					                    minlength: 8,
					                    maxlength: 24
					               } , 
					                   passwordAgain: { 
					                    equalTo: "#passworda",
					                     minlength: 8,
					                     maxlength: 24
					               }


					           },
					           
					     messages:{
					         passworda: { 
					                 minlength: "the password must be at least 8 characters long",
									 maxlength:"the password must be at most 24 characters long"
					               }
						}});
					</script>



					</div>
					<!--/span-->
				</div>
				<!--/row-->


			</div>
			<!--/.fluid-container-->

		</div>
		<!--/fluid-row-->
	</section>
	</main>
            </div>
	<jsp:include page="footer.jsp"></jsp:include>          
        </div>
</div>

	
</body>
</html>