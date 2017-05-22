<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<div>
<main>
		<section>
			<div class="container-fluid-full">
				<div class="row-fluid">
					<div class="login-box">

					
						<sf:form class="form-horizontal" method="post"
							id="registrationForm" action="register"
							modelAttribute="registerUser">
							<fieldset>
								<div class="input-prepend" title="Email">
									<p class="error-messages" id="emailErrorMsg">Email should
										not be longer than 64 characters</p>
									<label>Email:</label> <span class="add-on"><i
										class="halflings-icon envelope"></i></span>
									<sf:input class="form-control" path="email" id="email"
										type="email" placeholder="Enter email" required="required" />
									<sf:errors path="email" element="div" cssClass="error" />

								</div>

								<div class="input-prepend" title="Password">
									<p class="error-messages" id="pwdErrorMsg">Password should
										be greater than 8 characters</p>
									<label>Password:</label> <span class="add-on"><i
										class="halflings-icon lock"></i></span>
									<sf:input class="form-control" path="password" id="password"
										type="password" placeholder="Enter password"
										required="required" />
									<sf:errors path="password" element="div" />

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
									<sf:errors path="firstName" element="div" cssClass="error" />
								</div>

								<div class="input-prepend">
									<label>Last Name:</label> <span class="add-on"><i
										class="halflings-icon user"></i></span>
									<sf:input class="form-control" path="lastName" id="lastName"
										type="text" placeholder="Enter last name" required="required" />
									<sf:errors path="lastName" element="div" cssClass="error" />

								</div>
								<br />

								<div class="button-login">
									<button type="submit" class="btn btn-primary" id="regButton">Register</button>
									<button type="reset" class="btn btn-danger">Reset</button>
								</div>
							</fieldset>
						</sf:form>
					</div>
				</div>
			</div>
		</section>
		</main>
</div>


</body>
</html>