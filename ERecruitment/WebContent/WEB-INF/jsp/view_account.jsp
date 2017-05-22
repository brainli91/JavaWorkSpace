<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common/head.jsp"></jsp:include>
<link rel= "stylesheet" type="text/css" href="static/css/userpage_css.css">
<title>User Page</title>
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
		<!-- Your Main Body Content goes here -->
		<div class="row">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="well well-sm">
						<div class="row">
							<div class="col-sm-6 col-md-4">
								<img src="static/img/profile.png" alt="Profile Picture"
									class="img-rounded img-responsive" />
							</div>
							<div class="col-sm-6 col-md-8 text-info">
								<h4 class="profiletext">${user.firstName} ${user.lastName}</h4>
								<p>
									
									<i class="glyphicon glyphicon-envelope" title="Email"></i>&nbsp ${user.email} 
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	</section>
</main>	
            </div>
	<jsp:include page="footer.jsp"></jsp:include>          
        </div>
</div>



</body>
</html>