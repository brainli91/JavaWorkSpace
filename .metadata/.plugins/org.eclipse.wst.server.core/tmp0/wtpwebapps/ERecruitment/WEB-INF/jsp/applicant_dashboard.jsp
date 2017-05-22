<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <jsp:include page="common/head.jsp"></jsp:include>
  <link rel= "stylesheet" type="text/css" href="static/css/userpage_css.css">
  <title>Dashboard</title>
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
	  <h2>Latest Job Postings</h2>
      <br/>
	 <table id="jobTable" class="table table-striped table-bordered display">
        <thead>
          <tr>
            <th>#</th>
            <th>Job Title</th>
            <th>Job Description</th>
            <th style="white-space:nowrap;">Start-Date</th>
            <th>Application Deadline</th>
            <th>Number Of Positions</th>
            <th>Info</th>
            <th>Apply</th>
          </tr>
        </thead>
  
        <tbody>
          <c:forEach var="job" items="${jobs}" varStatus="jobCounter">
            <tr>
              <td style="display: none;">${job.id}</td>
              <td>${jobCounter.count}</td>
              <td>${job.title}</td>
              <td>${job.description}</td>
              <td style="white-space:nowrap;">${job.startDate}</td>
              <td style="white-space:nowrap;">${job.deadlineDate}</td>
              <td>${job.numOfPositions}</td>
              <td align="center">
              	<a href="applicantViewJob?jobId=${job.id}"><i class="glyphicon glyphicon-eye-open" style="font-size:20px;"></i></a>
              </td>
              <td align="center">
              	<form method="post" action="applyForJob">
              		<input name="jobId" type="hidden" value="${job.id}" />
              		<button type="submit">Apply </button>
              	</form>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <br/>
      
      <h2>Upcoming Interviews</h2>
      <br/>
	  <table id="interviewTable" class="table table-striped table-bordered display">
        <thead>
          <tr>
            <th>Position</th>
            <th>Recruiter</th>
            <th>Type</th>
            <th>Date</th>
            <th>Job Info</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="interview" items="${interviews}" varStatus="interviewCounter">
            <tr>
              <td>${interview.jobApplication.job.title}</td>
              <td>${interview.jobApplication.job.jobPoster.firstName} ${interview.jobApplication.job.jobPoster.lastName}</td>
              <td>${interview.type.name}</td>
              <td>${interview.date}</td>
              <td align="center">
                <a href="applicantViewApplication?jobId=${interview.jobApplication.job.id}&applicationStatus=${interview.jobApplication.status.name}"><i class="glyphicon glyphicon-eye-open" style="font-size: 20px;"></i></a>
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