<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <jsp:include page="common/head.jsp"></jsp:include>
  <link rel= "stylesheet" type="text/css" href="static/css/userpage_css.css">
  <title>View application and status</title>
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
      
      <h3>Skills Needed</h3>
      <p>${job.keywords}</p>
	  <br/>
	  
	  
	  <c:choose>
	  	<c:when test="${job.status.name=='Active'}">
	  		<h4>Status of the job:  </h4><h4 style="color:green;">${job.status.name}</h4>
	  	</c:when>
	  	<c:otherwise>
	  		<h4>Status of the job: </h4><h4 style="color:red;">${job.status.name}</h4>
	  	</c:otherwise>
	  </c:choose>
	  
	  <c:choose>
	  	<c:when test="${applicationStatus=='Pending'}">
	  		<h4>Status of application:  </h4><h4 style="color:yellow;">${applicationStatus}</h4>
	  	</c:when>
	  	<c:when test="${applicationStatus=='Accepted'}">
	  		<h4>Status of application:  </h4><h4 style="color:green;">${applicationStatus}</h4>
	  	</c:when>
	  	<c:otherwise>
	  		<h4>Status of application: </h4><h4 style="color:red;">${applicationStatus}</h4>
	  	</c:otherwise>
	  </c:choose>

	</section>
	</main>
            </div>
	<jsp:include page="footer.jsp"></jsp:include>          
        </div>
</div>
 


</body>
</html>