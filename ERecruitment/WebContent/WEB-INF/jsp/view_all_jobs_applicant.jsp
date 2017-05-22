<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="common/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="static/css/userpage_css.css">
<link rel="stylesheet" type="text/css"
	href="static/css/view_job_css.css">
	<link rel="stylesheet" type="text/css"
	href="static/css/errorPage_css.css">
<title>View Jobs</title>
</head>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="sidebar.jsp"></jsp:include>
		<div id="main-wrapper" class="col-md-11 pull-right">
			<div id="main">
				<main>
				<section>
				<h2>Available Jobs</h2>
                <br/>
        
				<c:if test="${not empty errorMsg}">
					<div id="general"
						class="errorMessage alert alert-danger"
						style="display: block">
						<div class="glyphicon glyphicon-remove-circle">&nbsp;${errorMsg}</div>
					</div>

				</c:if>
				
				<c:if test="${not empty successMsg}">
			<div class="success alert alert-success">
				<div class="glyphicon glyphicon-ok">&nbsp;${successMsg}</div>
			</div>

		 </c:if>
					<table id="jobTable"
						class="table table-striped table-bordered display">
						<thead>
							<tr>
								<th>#</th>
								<th>Job Title</th>
								<th>Job Description</th>
								<th>Application Deadline</th>
								<th style="white-space: nowrap;">Start-Date</th>
								<th>Number Of Positions</th>
								<th>Number of Applicants</th>
								<th>Info</th>
								<th>Apply</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="job" items="${jobs}" varStatus="jobCounter">
								<tr>
									<td>${jobCounter.count}</td>
									<td>${job.title}</td>
									<td>${job.description}</td>
									<td style="white-space: nowrap;">${job.deadlineDate}</td>
									<td style="white-space: nowrap;">${job.startDate}</td>
									<td>${job.numOfPositions}</td>
									<td>${fn:length(job.jobApplications)}</td>
									<td align="center"><a href="applicantViewJob?jobId=${job.id}"><i
											class="glyphicon glyphicon-eye-open" style="font-size: 20px;"></i></a>
									</td>
									<td align="center">
										<form method="post" action="applyForJob">
											<input name="jobId" type="hidden" value="${job.id}" />
											<button type="submit">Apply</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</section>
				</main>
			</div>
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>



</body>
</html>