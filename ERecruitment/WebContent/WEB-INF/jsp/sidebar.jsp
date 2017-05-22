<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="sidebar-wrapper" class="col-md-1">
	<div id="sidebar">
      <ul class="nav list-group">
        <li>
          <a class="list-group-item" href="dashboard">Dashboard</a>
        </li>
    	<c:choose>
          <c:when test="${sessionScope.user.role.name == 'applicant'}">
              <li>
                  <a class="list-group-item" href="viewMyProfile">View Profile</a>
              </li>
              <li>
                  <a class="list-group-item" href="editProfile">Edit Profile</a>
              </li>
              <li>
                  <a class="list-group-item" href="viewJobPostings">Browse Jobs</a>
              </li>
              <li>
                  <a class="list-group-item" href="applicantViewJobApps">Your Job Applications</a>
              </li>
              <li>
                  <a class="list-group-item" href="applicantViewInterviews">View Your Interviews</a>
              </li>
          </c:when>
          <c:when test="${sessionScope.user.role.name == 'recruiter'}">
              <li>
                  <a class="list-group-item" href="viewAllJobs">Browse All Jobs</a>
              </li>
              <li>
                  <a class="list-group-item" href="createOrEditJobView?jobId=">Create Job Posting</a>
              </li>
              <li>
                  <a class="list-group-item" href="viewAllRecruiterJobs">Your Posted Jobs</a>
              </li>
              <li>
                  <a class="list-group-item" href="recruiterViewInterviews">View Your Interviews</a>
              </li>
              <li>
                  <a class="list-group-item" href="viewStatistics">View Statistics</a>
              </li>
          </c:when>
          <c:when test="${sessionScope.user.role.name == 'admin'}">
              <li>
                  <a class="list-group-item" href="viewUsers">View All Users</a>
              </li>
              <li>
                  <a class="list-group-item" href="createUser">Create New User</a>
              </li>
              <li>
                  <a class="list-group-item" href="userLog">View User Log</a>
              </li>
              <li>
                  <a class="list-group-item" href="systemLog">View System Log</a>
              </li>
          </c:when>
          <c:when test="${sessionScope.user.role.name == 'manager'}">
              <li>
                  <a class="list-group-item" href="viewStatistics">View Statistics</a>
              </li>
          </c:when>
        </c:choose>  
      </ul>      
	</div>
</div>