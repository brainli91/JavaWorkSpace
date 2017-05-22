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
	href="static/css/userpage_css.css">
<link rel="stylesheet" type="text/css" href="static/css/errorPage_css.css" >
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
    <c:if test="${not empty successMsg}">
			<div class="success alert alert-success">
				<div class="glyphicon glyphicon-ok">&nbsp;${successMsg}</div>
			</div>

		 </c:if>
       <c:if test="${not empty errorMsg}">
			<div class="errorMessage alert alert-danger login-box">
				<div class="glyphicon glyphicon-remove-circle">&nbsp;${errorMsg}</div>
			</div>

		 </c:if>
      <h2>
        Interviews scheduled for ${jobApplication.applicant.firstName} ${jobApplication.applicant.lastName}
        for position: ${jobApplication.job.title}
      </h2>
      <br/><br/>
    
      <table id="jobTable" class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>#</th>
            <th>Type</th>
            <th>Result</th>
            <th>Date</th>
            <th>Edit</th>
          </tr>
        </thead>
      
        <tbody>
          <c:forEach var="interview" items="${jobApplication.interviews}" varStatus="interviewCounter">
            <tr>
              <td>${interviewCounter.count}</td>
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
              <td>${interview.date}</td>
              <td align="center">
                <a href="addOrEditInterview?jobAppId=${jobApplication.id}&interviewId=${interview.id}"><i class="glyphicon glyphicon-pencil" style="font-size:20px;"></i></a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href="recruiterViewJob?jobId=${jobApplication.job.id}">
        <button type="button" class="btn btn-default">Go Back</button>
      </a>
      <a href="addOrEditInterview?jobAppId=${jobApplication.id}&interviewId=">
        <button type="button" class="btn btn-default" style="float: right;">Add Interview</button>
      </a>
    </section>
  </main>
            </div>
	<jsp:include page="footer.jsp"></jsp:include>          
        </div>
</div>
  

</body>
</html>