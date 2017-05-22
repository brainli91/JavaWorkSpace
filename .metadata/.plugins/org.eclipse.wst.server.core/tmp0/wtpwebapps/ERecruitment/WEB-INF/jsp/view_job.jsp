<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <jsp:include page="common/head.jsp"></jsp:include>
  <link rel= "stylesheet" type="text/css" href="static/css/userpage_css.css">
  <link rel="stylesheet" type="text/css"  href="static/css/errorPage_css.css">
  <title>View Job</title>
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
     	<c:if test="${not empty errorMsg}">
			<div class="errorMessage alert alert-danger login-box">
				<div class="glyphicon glyphicon-remove-circle">&nbsp;${errorMsg}</div>
			</div>
		 </c:if>
		  <c:if test="${not empty successMsg}">
			<div class="success alert alert-success">
				<div class="glyphicon glyphicon-ok">&nbsp;${successMsg}</div>
			</div>

		 </c:if>
   <%--  ${errorMsg}
    ${successMsg} --%>
      <h1>${job.title}</h1>
      <br />
  
      <h3>Job Description</h3>
      <p>${job.description}</p>
  
      <h3>Deadline</h3>
      <p>${job.deadlineDate}</p>

      <h3>Start Date</h3>
      <p>${job.startDate}</p>
  
      <h3>Number of Positions</h3>
      <p>${job.numOfPositions}</p>
      
      <h3>Keywords</h3>
      <p>${job.keywords}</p>
      </br>
      <h3>Applicants:</h3>
      <table id="jobTable" class="table table-striped table-bordered display">
        <thead>
          <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Primary Phone</th>
            <th>Match</th>
            <th>Status</th>
            <th>Full Profile</th>
            <th>Interview</th>
            <th>Accept/Reject</th>
          </tr>
        </thead>
  
        <tbody>
          <c:forEach var="application" items="${job.jobApplications}" varStatus="applicationCounter">
            <tr>
              <td>${applicationCounter.count}</td>
              <td>${application.applicant.firstName}</td>
              <td>${application.applicant.lastName}</td>
              <td>${application.applicant.email}</td>
              <td>${application.applicant.applicantProfile.primaryPhone}</td>
              <td>
              	<div class="progress">
              		<c:choose>
              			<c:when test="${application.score lt 40}">
              				<div class="progress-bar progress-bar-danger" role="progressbar"
		              			 aria-valuenow="${application.score}" aria-valuemin="0" aria-valuemax="100"	
		              			 style="width: ${application.score}%; color: black;">
								<fmt:formatNumber value="${application.score}" minFractionDigits="0" maxFractionDigits="0" />%
	              			</div>
              			</c:when>
              			<c:when test="${application.score lt 65}">
              				<div class="progress-bar progress-bar-warning" role="progressbar"
		              			 aria-valuenow="${application.score}" aria-valuemin="0" aria-valuemax="100"	
		              			 style="width: ${application.score}%; color: black;">
								<fmt:formatNumber value="${application.score}" minFractionDigits="0" maxFractionDigits="0" />%
	              			</div>
              			</c:when>
              			<c:otherwise>
              				<div class="progress-bar progress-bar-success" role="progressbar"
		              			 aria-valuenow="${application.score}" aria-valuemin="0" aria-valuemax="100"	
		              			 style="width: ${application.score}%; color: black;">
								<fmt:formatNumber value="${application.score}" minFractionDigits="0" maxFractionDigits="0" />%
	              			</div>
              			</c:otherwise>
              		</c:choose>
              	</div>
              </td>
              <c:choose>
                <c:when test="${application.status.name == 'Accepted'}">
                  <td align="center" style="color: green">${application.status.name}</td>
                </c:when>
                <c:when test="${application.status.name == 'Rejected'}">
                  <td align="center" style="color: red">${application.status.name}</td>
                </c:when>
                <c:when test="${application.status.name == 'Pending'}">
                  <td align="center" style="color: #FF8C00">${application.status.name}</td>
                </c:when>
              </c:choose>
              <td align="center">
                <a href="viewApplicantProfile?applicant=${application.applicant.id}"><i class="glyphicon glyphicon-eye-open" style="font-size:20px;"></i></a>
              </td>
              <td align="center">
                <a href="jobApplicationViewInterviews?application=${application.id}"><i class="glyphicon glyphicon-time" style="font-size:20px;"></i></a>
              </td>
              <td align="center">
                 <a href="jobApplicationAcceptApplicant?jobId=${job.id}&application=${application.id}"><i class="glyphicon glyphicon-ok" style="font-size:20px;"></i></a>
                &nbsp;&nbsp;<a href="jobApplicationRejectApplicant?jobId=${job.id}&application=${application.id}"><i class="glyphicon glyphicon-remove" style="font-size:20px;"></i></a>
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