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
	<link rel="stylesheet" type="text/css"
	href="static/css/errorPage_css.css">
	<script type="text/javascript" src="static/js/create-email-validate.js"></script>
<title>Create New User</title>
</head>
<body>

	<header>
		<jsp:include page="navbar.jsp"></jsp:include>
	</header>
	<div class="main-row">

   

<jsp:include page="navbar.jsp"></jsp:include>
<div id="wrapper">
	<jsp:include page="sidebar.jsp"></jsp:include>
    <div id="main-wrapper" class="col-md-11 pull-right">
    	<div id="main">
        	
    	<!-- main content goes here -->
    	<main>

	<section>
	 <c:if test="${not empty errorMsg}">
			<div class="errorMessage alert alert-danger login-box">
				<div class="glyphicon glyphicon-remove-circle">&nbsp;${errorMsg}</div>
			</div>

		 </c:if>
		 		<ul>
			<div id="errors" class="errorMessage alert alert-danger login-box" style="display: none">
			
				<div class="glyphicon glyphicon-remove-circle"></div>
			</div>
			</ul>
		<!-- Your Main Body Content goes here -->
		<!-- If you want to change the position of the main(which contains the content) then create a new user_head.jsp and new css for it and just reposition main
		but just copy and paste the original user_head.jsp, and user_page_css.css -->
		<%-- <h2 style="color: red">${errorMsg}</h2> --%>
		<h2>Create A User</h2><br/>
    
		<div class="container-fluid-full registerBox" align="center">
		<div class="row-fluid">

			<div class="row-fluid">
				<div class="login-box">
					<div class="icons">
						<a href=""><i class="halflings-icon home"></i></a>
					</div>
					<sf:form class="form-horizontal" method="post"
						id="createUserForm" action="createUser"
						modelAttribute="newUser">
						<fieldset>
							<div class="input-prepend" title="Username">
								<label>Email:</label> <span class="add-on"><i
									class="halflings-icon envelope"></i></span>

									<%-- <h2 style="color: red">${errorMsg}</h2> --%>

								<sf:input class="form-control" path="email" id="email"
									type="email" placeholder="Enter email" required="required" />
							</div>

							<div class="input-prepend" title="Password">
								<label>Password:</label> <span class="add-on"><i
									class="halflings-icon lock"></i></span>
								<input class="form-control" name="password" id="password"
									type="password" placeholder="Enter password"
									required="required" />
							</div>

							<div class="input-prepend">
								<label>Confirm Password:</label> <span class="add-on"><i
									class="halflings-icon lock"></i></span> <input class="form-control"
									name="passwordAgain" id="passwordAgain" type="password"
									placeholder="Enter password again" required="required" />
							</div>

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
							<div>
								<label>Role:</label>
									<br/>
									<input id="recruiter" name="roleName" type="radio"
										value="recruiter" required> <label>Recruiter
									</label>
									<input id="applicant" name="roleName" type="radio" value="applicant"
										required> <label>Applicant</label>
									<input id="admin" name="roleName" type="radio" value="admin"
										required> <label>Admin</label>
								
							</div>
							<br />

							<div class="button-login">
								<button type="submit" class="btn btn-primary">Create</button>
								<button type="reset" class="btn btn-danger">Reset</button>

							</div>
						</fieldset>
					</sf:form>

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
            </div>
	<jsp:include page="footer.jsp"></jsp:include>          
        </div>
</div>
	
</body>
</html>