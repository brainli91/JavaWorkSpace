<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <jsp:include page="common/head.jsp"></jsp:include>
  <link rel= "stylesheet" type="text/css" href="static/css/userpage_css.css">
  <link rel="stylesheet" type="text/css"
	href="static/css/errorPage_css.css">
  <title>View Interviews</title>
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
      <h2>
        Your Interviews
      </h2>
      <br/>
    
      <table id="jobTable" class="table table-striped table-bordered display" cellspacing="0" width="100%">
      <c:choose>
            <c:when test="${sessionScope.user.role.name == 'applicant'}">
            	<thead>
		          <tr>
		            <th>#</th>
		            <th>Job Title</th>
		            <th>Date</th>
		            <th>Type</th>
		            <th>Result</th>
                    <th>Job Info</th>
		          </tr>
		        </thead>
		        <tbody>
		          <c:forEach var="interview" items="${interviews}" varStatus="interviewCounter">
		            <tr>
		              <td>${interviewCounter.count}</td>
		              <td>${interview.jobApplication.job.title}</td>
		              <td>${interview.date}</td>
		              <td>${interview.type.name}</td>
                      <c:choose>
                        <c:when test="${interview.result.name == 'Pass'}">
                          <td style="color: green;">${interview.result.name}</td>
                        </c:when>
                        <c:when test="${interview.result.name == 'Fail'}">
                          <td style="color: red;">${interview.result.name}</td>
                        </c:when>
                        <c:when test="${interview.result.name == 'Pending'}">
                          <td style="color: orange;">${interview.result.name}</td>
                        </c:when>
                        <c:when test="${interview.result.name == 'Cancelled'}">
                          <td style="color: gray;">${interview.result.name}</td>
                        </c:when>
                      </c:choose>
                      <td align="center">
                        <a href="applicantViewApplication?jobId=${interview.jobApplication.job.id}&applicationStatus=${interview.jobApplication.status.name}"><i class="glyphicon glyphicon-eye-open" style="font-size: 20px;"></i></a>
                      </td>
		            </tr>
		          </c:forEach>
		        </tbody>
            </c:when>
      <c:otherwise>
        <thead>
          <tr>
            <th>#</th>
            <th>Date</th>
            <th>Job Title</th>
            <th>Applicant Name</th>
            <th>Type</th>
            <th>Result</th>
            <th>Job Info</th>
            <c:if test="${user.role.name == 'recruiter'}">
              <th>Edit</th>
            </c:if>
          </tr>
        </thead>
		      
        <tbody>
          <c:forEach var="interview" items="${interviews}" varStatus="interviewCounter">
            <tr>
              <td>${interviewCounter.count}</td>
              <td>${interview.date}</td>
              <td>${interview.jobApplication.job.title}</td>
              <td>${interview.jobApplication.applicant.firstName } ${interview.jobApplication.applicant.lastName }</td>
              <td>${interview.type.name}</td>
              <c:choose>
                <c:when test="${interview.result.name == 'Pass'}">
                  <td style="color: green;">${interview.result.name}</td>
                </c:when>
                <c:when test="${interview.result.name == 'Fail'}">
                  <td style="color: red;">${interview.result.name}</td>
                </c:when>
                <c:when test="${interview.result.name == 'Pending'}">
                  <td style="color: orange;">${interview.result.name}</td>
                </c:when>
                <c:when test="${interview.result.name == 'Cancelled'}">
                  <td style="color: gray;">${interview.result.name}</td>
                </c:when>
              </c:choose>
              <td align="center">
                <c:choose>
                  <c:when test="${sessionScope.user.role.name == 'recruiter'}">
                    <a href="recruiterViewJob?jobId=${interview.jobApplication.job.id}"><i class="glyphicon glyphicon-eye-open" style="font-size:20px;"></i></a>
                  </c:when>
                  <c:otherwise>
                    <a href="applicantViewJob?jobId=${interview.jobApplication.job.id}"><i class="glyphicon glyphicon-eye-open" style="font-size:20px;"></i></a>
                  </c:otherwise>
                </c:choose>
              </td>
              <c:if test="${user.role.name == 'recruiter'}">
                <td align="center">
                  <a href="addOrEditInterview?jobAppId=${interview.jobApplication.id}&interviewId=${interview.id}"><i class="glyphicon glyphicon-pencil" style="font-size:20px;"></i></a>
                </td>
            </c:if>
            </tr>
          </c:forEach>
        </tbody>
      </c:otherwise>
      </c:choose>
    </table>
      
      <!-- <button type="button" class="btn btn-default">Go Back</button> -->
    </section>
  </main>
            </div>
	<jsp:include page="footer.jsp"></jsp:include>          
        </div>
</div>
  
  

</body>
</html>