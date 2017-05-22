<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="common/head.jsp"></jsp:include>
	<script type="text/javascript" src="static/js/profile_form_js.js"></script>
	<link rel= "stylesheet" type="text/css" href="static/css/userpage_css.css">
	<link rel="stylesheet" type="text/css" href="static/css/profile_form_css.css" />
	<link rel="stylesheet" type="text/css"
	href="static/css/errorPage_css.css">
	<style>
		.errors {
			color: red;
		}
	</style>
	<title>Create/Edit Profile</title>
</head>
<header>
<jsp:include page="navbar.jsp"></jsp:include>
</header>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
<div id="wrapper">
	<jsp:include page="sidebar.jsp"></jsp:include>
    <div id="main-wrapper" class="col-md-11 pull-right">
    	<div id="main">
        	
            	<!-- main content goes here -->
    
            	<main>
	
	<section>

	<div class="container" align="center">
		<h2>Create/edit your profile</h2><br/>
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
		<%-- <h5 class="errors">${errorMsg}</h5> --%>
		<%-- <h5 class="success">${successMsg}</h5> --%>
      
        <label class="radio-inline"><input type="radio" name="formChoice" id="uploadResumeRadio">Upload resume</label>
        <label class="radio-inline"><input type="radio" name="formChoice" id="fillInFieldsRadio">Fill in form</label>

        <sf:form class="form-horizontal" id="uploadResumeForm" modelAttribute="uploadForm" method="post" action="savefiles" enctype="multipart/form-data" hidden="true">
          <h3>Upload Resume</h3>
          <h5>(Accepts:&nbsp;&nbsp;.PDF&nbsp;&nbsp;.DOCX&nbsp;&nbsp;.DOC&nbsp;&nbsp;.TXT)</h5>
          <br/>
          <input name="resumeFile" type="file" />
          <br />
          <input type="submit" value="Upload" />
        </sf:form>
        <div align="left">
        <sf:form class="form-horizontal" id="profileForm" method="post"  action="editProfile" modelAttribute="applicantProfile" hidden="true">
          <h3>Resume Form</h3>
          <h4>Contact Info</h4>
          <div class="form-group">
            <sf:label path="address">Address</sf:label>
            <sf:input type="text" path="address" id="address" class="form-control" placeholder="123 Street, City, Province/State, Country, Postal Code" value="${applicantProfile.address }" required="required" />
          </div>
          <div class="form-group">
            <sf:label path="primaryPhone">Primary Phone</sf:label>
            <sf:input type="text" class="form-control" path="primaryPhone" id="primaryPhone" placeholder="555-555-5555" value="${applicantProfile.primaryPhone}" required="required" />
          </div>
          <div class="form-group">
            <sf:label path="secondaryPhone">Secondary Phone</sf:label><br/>
            <sf:input  type="text" class="form-control" path="secondaryPhone" placeholder="555-555-5555" value="${applicantProfile.secondaryPhone}"  />
          </div>
          <hr>
          <h4>Skills</h4>
          <c:set var="countSkill" value="0" scope="page"/>
          <c:if test="${fn:length(skills) gt 0 && skills ne '[]'}">
	          <c:forEach items="${skills}" var="skill">
		          <div class='singleSkill' id='singleSkill[${countSkill}]'> ${skill}
		          	<span class='glyphicon glyphicon-remove' onclick='deleteSkill("${skill}",${countSkill})' aria-hidden='true'>
		          	</span>
		          </div>
		         <c:set var="countSkill" value="${countSkill+ 1}" scope="page"/>
	          </c:forEach>
	      </c:if>
          <div id="skillsList" class="form-group">
          	<div class="errors" id="skillErrors"></div>
            <input class="form-control" type="text" id="skillField" placeholder="Skill" />
            <button type="button" id="addSkillFieldButton">Add Skill</button>
          </div>
          
          <div id="educationList">
          	<c:set var="countEdu" value="0" scope="page" />
          		<c:forEach items="${applicantProfile.education}" var="education">
          				<div class="errors" id="sendEdErrors[${countEdu}]"></div>
			            <div class="education" id="education[${countEdu}]">
			            <h4>Education</h4>
			             <div id="editEducationDiv[${countEdu}]">
		            		<span id="editButtonEducation[${countEdu}]" class="glyphicon glyphicon-cog" aria-hidden="true" onClick="makeEditableEducation(${countEdu})"></span>
		            	</div>
		            	<input class="form-control" type="hidden" id="educationId[${countEdu}]" value="${education.id}">
			            <div class="form-group">
			              <label for="institution[${countEdu}]">Institution:</label></br>
			              <input class="form-control" type="text" id='institution[${countEdu}]' name="institution" placeholder="College/University" value="${education.institution}" disabled/>
			            </div>
			            <div class="form-group">
			              <label for="startDate[${countEdu}]">Start Date</label>
			              <input class="form-control" type="date" id="startDate[${countEdu}]" name="startDate" placeholder="Start Date" value="${education.startDate}" disabled/>
			            </div>
			            <div class="form-group">
			              <label for="endDate[${countEdu}]">End Date</label>
			              <input class="form-control" type="date" id="endDate[${countEdu}]" name="endDate" placeholder="End Date" value="${education.endDate}" disabled/>
			            </div>
			            <div class="form-group">
			              <label for="degree[${countEdu}]">Degree</label>
			              <input  class="form-control" type="text" id="degree[${countEdu}]" name="degree" placeholder="Degree" value="${education.degree}" disabled/>
			            </div>
			            <div class="form-group">
			              <label for="program[${countEdu}]">Program</label>
			              <input  class="form-control" type="text" id="program[${countEdu}]" name="program" placeholder="Program" value="${education.program}" disabled/>
			            </div>
			            
			            <div id="sendEducationButton[${countEdu}]">
			            	<span class='glyphicon glyphicon-ok' aria-hidden='true' title="Saved"></span>
			            </div>
			          </div>
		            	
	            <c:set var="countEdu" value="${countEdu + 1}" scope="page"/>
	            </c:forEach>
	          <button type="button" id="addEducationButton">Add Education</button>
          </div>
          
          <div id="workHistoryList">
          	<c:set var="countWork" value="0" scope="page" />
          	<c:forEach items="${applicantProfile.workHistory}" var="workHistory">	
          	  <div class="errors" id="workHisErrors[${countWork}]"></div>
	          <div class="workHistory" id="workHistory[${countWork}]">
	          <br/>
	            <h4 style="display:inline">Job&nbsp;</h4>
	            <div id="editWorkDiv[${countWork}]">
	            	<span id="editButtonWork[${countWork}]" class="glyphicon glyphicon-cog" aria-hidden="true" onClick="makeEditableWork(${countWork})"></span>
	            </div>
	            <input type="hidden" id="workHistoryId[${countWork}]" value="${workHistory.id}">
	            <div class="form-group">
	              <label for="employer[${countWork}]">Employer</label>
	              <input class="form-control" type="text" id="employer[${countWork}]" name="employer" placeholder="Employer" value="${workHistory.employer}" disabled/>
	            </div>
	            <div class="form-group">
	              <label for="startDateWork[${countWork}]">Start Date</label>
	              <input class="form-control" type="date" id="startDateWork[${countWork}]" name="startDate" placeholder="Start Date" value="${workHistory.startDate}" disabled/>
	            </div>
	            <div class="form-group">
	              <label for="endDateWork[${countWork}]">End Date</label>
	              <input class="form-control" type="date" id="endDateWork[${countWork}]" name="endDate" placeholder="End Date" value="${workHistory.endDate}" disabled/>
	            </div>
	            <div class="form-group">
	              <label for="title[${countWork}]">Job Title</label>
	              <input  class="form-control" type="text" id="title[${countWork}]" name="title" placeholder="Title" value="${workHistory.title}" disabled/>
	            </div>
	            <div class="form-group">
	              <label for="description[${countWork}]">Description</label>
	              <textarea id="description[${countWork}]" name="description" placeholder="Description" rows="3" disabled>${workHistory.description}</textarea>
	            </div>
	            <div id="sendWorkHistoryButton[${countWork}]">
	            	<span class='glyphicon glyphicon-ok' aria-hidden='true' title="Saved"></span>
	            	<br/>
	            </div>
	          </div>
	           <c:set var="countWork" value="${countWork + 1}" scope="page"/>
	         </c:forEach>
	          <button type="button" id="addWorkHistoryButton">Add Work History</button>
          </div>
          <hr>
          <h4>Interests</h4>
          <div id="interestsList" class="form-group">
          <c:set var="countInterest" value="0" scope="page"/>
          <c:if test="${fn:length(interests) gt 0 && interests ne '[]'}">
	          <c:forEach items="${interests}" var="interest">
		          <div class='singleInterest' id='singleInterest[${countInterest}]'> ${interest}
		          	<span class='glyphicon glyphicon-remove' onclick='deleteInterest("${interest}",${countInterest})' aria-hidden='true'>
		          	</span>
		          </div>
		         <c:set var="countInterest" value="${countInterest+ 1}" scope="page"/>
	          </c:forEach>
	     </c:if>
          	<div class="errors" id="interestErrors"></div>
            <input class="form-control" type="text" id="interestField" placeholder="Interest" />
            <button type="button" id="addInterestFieldButton">Add Interest</button>
          </div>
          
          <div id="errors" class="errorMessage alert alert-danger login-box" style="display: none">
          	<div class="glyphicon glyphicon-remove-circle"></div>
          </div>
          
          <input type="submit" class="btn btn-primary btn-lg" value="Save Profile" />
          
          
        </sf:form>
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