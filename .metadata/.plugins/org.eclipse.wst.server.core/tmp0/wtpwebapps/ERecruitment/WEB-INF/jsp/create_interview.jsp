<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <jsp:include page="common/head.jsp"></jsp:include>
  <link rel= "stylesheet" type="text/css" href="static/css/userform_css.css">
  <script type="text/javascript" src = "static/js/interview-validate.js"> </script>
  <link rel="stylesheet" type="text/css"
	href="static/css/errorPage_css.css">
  <title>Schedule an Interview</title>
</head>

<body>

 <jsp:include page="navbar.jsp"></jsp:include>
<div id="wrapper">
	<jsp:include page="sidebar.jsp"></jsp:include>
    <div id="main-wrapper" class="col-md-11 pull-right">
    	<div id="main">
        	
            	<!-- main content goes here -->
            	 <main align="center">
    <section>
    <c:if test="${not empty errorMsg}">
			<div class="errorMessage alert alert-danger login-box">
				<div class="glyphicon glyphicon-remove-circle">&nbsp;${errorMsg}</div>
			</div>

		 </c:if>
      <h2>${interview.id == 0 ? 'Create' : 'Edit'} Interview</h2>
      <br/>
    
      <sf:form id="createInterviewForm" modelAttribute="interview" 
        method="post" action="addOrEditInterview">
        
        <input type="hidden" name="interviewId" value="${interview.id}"/>
        <input type="hidden" name="jobAppId" value="${jobAppId}"/>
        
        <div class="form-group">
          <sf:label path="type">&nbspInterview Type&nbsp&nbsp</sf:label>
          <sf:select id="fieldSize2" path="type">
            <sf:option value="PHONE">Phone</sf:option>
            <sf:option value="IN_PERSON">In Person</sf:option>
            <sf:option value="ASSESSMENT">Assessment</sf:option>
            <sf:option value="ONLINE">Online</sf:option>
          </sf:select>
        </div>
        
        <div class="form-group">
          <sf:label path="date">Interview Date&nbsp&nbsp&nbsp</sf:label>
          <sf:input type="date" path="date" id="date" onchange="checkDate()" />
        </div>
        
        <div class="form-group">
          <sf:label path="result">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspResult&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</sf:label>
          <sf:select id="fieldSize2" path="result">
            <sf:option value="PASS">Pass</sf:option>
            <sf:option value="FAIL">Fail</sf:option>
            <sf:option value="PENDING">Pending</sf:option>
            <sf:option value="CANCELLED">Cancelled</sf:option>
          </sf:select>
        </div>
        
        <br/>
<!--         <a href="viewInterviewsTest">
          <button type="button" class="btn btn-default">Go Back</button>
        </a> -->
		<sf:button type="submit" class="btn btn-primary btn-lg">Submit</sf:button>
		<sf:button type="reset" class="btn btn-danger btn-lg">Reset</sf:button>
      
      </sf:form>
      
    </section>
  </main>
            </div>
	<jsp:include page="footer.jsp"></jsp:include>          
        </div>
</div>

 

</body>
</html>