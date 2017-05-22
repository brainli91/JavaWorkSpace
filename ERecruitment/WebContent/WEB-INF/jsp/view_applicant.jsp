<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="static/css/userpage_css.css">
	<link rel="stylesheet" type="text/css"
	href="static/css/errorPage_css.css">
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
	<c:if test="${not empty successMessage}">
			<div class="success alert alert-success">
				<div class="glyphicon glyphicon-ok">&nbsp;${successMessage}</div>
			</div>

		 </c:if>
	<c:if test="${not empty errorMessage}">
			<div class="errorMessage alert alert-danger login-box">
				<div class="glyphicon glyphicon-remove-circle">&nbsp;${errorMessage}</div>
			</div>

		 </c:if>
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
									<h4 class="profiletext">${applicant.firstName}
										${applicant.lastName}</h4>
									<i class="glyphicon glyphicon-map-marker"> </i>&nbsp;
									
									<c:choose>
											<c:when test="${not empty applicant.applicantProfile.address}">
												&nbsp;${applicant.applicantProfile.address}
											</c:when>
											<c:otherwise>
												None
											</c:otherwise>
										</c:choose>
									<p>

										<i class="glyphicon glyphicon-envelope" title="Email"></i> 
										<c:choose>
											<c:when test="${not empty applicant.email}">
												&nbsp;${applicant.email}
											</c:when>
											<c:otherwise>
												None
											</c:otherwise>
										</c:choose>
										<br /> 
										<i class="glyphicon glyphicon-phone-alt" title="Primary Phone"></i>
										<c:choose>
											<c:when test="${not empty applicant.applicantProfile.primaryPhone}">
												&nbsp;${applicant.applicantProfile.primaryPhone}
											</c:when>
											<c:otherwise>
												None
											</c:otherwise>
										</c:choose>
										<br />
										<i class="glyphicon glyphicon-phone" title="Secondary Phone"></i>
										<c:choose>
											<c:when test="${not empty applicant.applicantProfile.secondaryPhone}">
												&nbsp;${applicant.applicantProfile.secondaryPhone}
											</c:when>
											<c:otherwise>
												None
											</c:otherwise>
										</c:choose>
										
									<p>
										<strong>Skills:</strong>
										<c:set var="skills"
											value="${fn:split(applicant.applicantProfile.skills, '|')}" />
										<c:choose>
											<c:when test="${not empty applicant.applicantProfile.skills}">
												<c:forEach items="${skills}" var="skill" varStatus="row">
												<c:if test="${row.count % 2 == 0}">
													<span class="label label-primary">${skill}</span>&nbsp;
												</c:if>
												<c:if test="${row.count % 2 != 0}">
													<span class="label label-warning">${skill}</span>&nbsp;
												</c:if>
											</c:forEach>		
											</c:when>
											<c:otherwise>
												None
											</c:otherwise>
										</c:choose>
									</p>
									<p>
										<strong>Interests: </strong>
										<c:set var="interests"
											value="${fn:split(applicant.applicantProfile.interests, '|')}" />
										<c:choose>
											<c:when test="${not empty applicant.applicantProfile.interests}">
												<c:forEach items="${interests}" var="interest" varStatus="row">
												<c:if test="${row.count % 2 == 0}">
													<span class="label label-primary">${interest}</span>&nbsp;
												</c:if>
												<c:if test="${row.count % 2 != 0}">
													<span class="label label-warning">${interest}</span>&nbsp;
												</c:if>
											</c:forEach>		
											</c:when>
											<c:otherwise>
												None
											</c:otherwise>
										</c:choose>
										 
									<p>
									
										<strong>Resume:</strong> 
										<c:choose>
											<c:when test="${empty applicant.applicantProfile.resume.filePath}">
													No resume on file
													<br />
											</c:when>
											<c:otherwise>
												<a id="fileDownload" class="btn btn-primary btn-sm" 
												href="${pageContext.request.contextPath}/${applicant.applicantProfile.resume.filePath}">Resume</a>
												<br />											
											</c:otherwise>
										</c:choose>

									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%-- <h4 class="successMessage">${successMessage}</h4>
		<h4 class="errorMessage">${errorMessage}</h4> --%>
		<h2>Work History: <c:if test="${empty applicant.applicantProfile.workHistory}">None</c:if> </h2><br/>
		<c:if test="${not empty applicant.applicantProfile.workHistory}">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Employer</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Title</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${applicant.applicantProfile.workHistory}"
						var="workHistory" varStatus="workHistoryCounter">
						<tr>
							<td>${workHistoryCounter.count}</td>
							<td>${workHistory.employer}</td>
							<td>${workHistory.startDate}</td>
							<td>${workHistory.endDate}</td>
							<td>${workHistory.title}</td>
							<td>${workHistory.description}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>



		<h2>Education: 	<c:if test="${empty applicant.applicantProfile.education}">None</c:if></h2><br/>
		<c:if test="${not empty applicant.applicantProfile.education}">

			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Institution</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Degree</th>
						<th>Program</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${applicant.applicantProfile.education}"
						var="education" varStatus="educationCounter">
						<tr>
							<td>${educationCounter.count}</td>
							<td>${education.institution}</td>
							<td>${education.startDate}</td>
							<td>${education.endDate}</td>
							<td>${education.degree}</td>
							<td>${education.program}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

	</section>
	</main>





</body>
</html>