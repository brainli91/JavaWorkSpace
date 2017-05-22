<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="common/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="static/css/userform_css.css">
<script type="text/javascript" src="static/js/job-validate.js"> </script>
<link rel="stylesheet" type="text/css"
	href="static/css/errorPage_css.css">
<link rel="stylesheet" type="text/css"
	href="static/css/errorPage_css.css">
<title>${job.id == 0 ? 'Create' : 'Edit'} Job</title>
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
					<c:if test="${not empty errorMessage}">
						<div class="errorMessage alert alert-danger login-box">
							<div class="glyphicon glyphicon-remove-circle">&nbsp;${errorMessage}</div>
						</div>

					</c:if>
					<h2>${job.id == 0 ? 'Create New' : 'Edit'} Job</h2>
					<div class="container">
						<div class="col-sm-offset-2 col-sm-9">
					
					<sf:form id="createJobForm" modelAttribute="job" method="post"
						action="postJob">

						<input type="hidden" name="jobId" value="${job.id}" />
						
						<div class="form-group col-xs-12 col-centered">
							<sf:label path="title">Job Title</sf:label>
							<br />
							<sf:input type="text" path="title" placeholder=""
								required="required" id="jobTitle" maxlength="50" />
						</div>
						
						<div class="form-group col-xs-12">
							<sf:label path="description">Job Description</sf:label>
							<br />
							<sf:textarea path="description" id="descriptionField"
								placeholder="" style="width:700px;max-width:700px" rows="5"
								required="required"></sf:textarea> 
						</div>
						
						<div class="form-group col-md-4">
							<sf:label path="startDate">Start Date</sf:label>
							<br />
							<sf:input type="date" path="startDate" required="required"
								id="startDate" onchange="checkStartDate()" />
						</div>
						
						<div class="form-group col-md-4 col-md-offset-4">
							<sf:label path="numOfPositions">Number of Positions</sf:label>
							<br />
							<sf:input id="fieldSize" type="number" min="1" max="20" maxlength="2" value="1"
								path="numOfPositions" />
						</div>

						<div class="form-group col-xs-4">
							<sf:label  path="deadlineDate">Deadline to Apply</sf:label>
							<br />
							<sf:input type="date" path="deadlineDate" required="required"
								onchange="checkDeadline()" id="deadline" />
						</div>

						<div class="form-group col-xs-4 col-md-offset-4">
							<sf:label path="keywords">Desirable Skills</sf:label>
							<br />
							<sf:select id="fieldSize" path="keywords" multiple="true" required="required">
								<sf:option value="Java" />
								<sf:option value="SQL" />
								<sf:option value="UNIX" />
								<sf:option value="Spring" />
								<sf:option value="Testing" />
								<sf:option value="C++" />
								<sf:option value="C#" />
								<sf:option value=".NET" />
							</sf:select>
						</div>
						


						<div class="form-group"
							${job.id == 0 ? 'style="display: none;"' : '' }>
							<sf:label path="status">Status</sf:label>
							<br />
							<sf:select path="status" required="required">
								<sf:option value="ACTIVE" selected="selected">Active</sf:option>
								<sf:option value="COMPLETED">Completed</sf:option>
								<sf:option value="CANCELLED">Cancelled</sf:option>
							</sf:select>
						</div>
						
						<div class="form-group col-md-8 col-md-offset-4">
						<sf:button type="submit" class="btn btn-primary btn-lg">Submit</sf:button>
						<sf:button type="reset" class="btn btn-danger btn-lg">Reset</sf:button>
						</div>
						
					</sf:form>
				</div>
				</div>
				
				</section>
				</main>

			</div>

		</div>
	</div>


</body>

</html>