<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="header" class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-header">
        <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <i class="icon-reorder"></i>
        </button>
        <a class="navbar-brand" href="">
            <img alt="" src="static/img/e-Recruitment-logo.png" width="50%" class="logo">
        </a>
    </div>
    <nav class="collapse navbar-collapse">
         <ul class="nav navbar-nav pull-right">
            <c:choose>
      		<c:when test="${sessionScope.user == null}">
            	<li class="has-submenu"><a href="register"><span class="glyphicon glyphicon-user"></span>&nbsp;Register</a></li>
        	<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Login</a></li>
      		</c:when>
     		<c:otherwise>
            		<li class="dropdown">
                	<a href="#" id="nbAcctDD" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>&nbsp;${sessionScope.user.firstName} ${sessionScope.user.lastName}<i class="icon-sort-down"></i></a>
                	<ul class="dropdown-menu pull-right">
            		<li><a href="editCurrentUser"><span class="glyphicon glyphicon-cog"></span>&nbsp;Edit Account</a></li>
            		<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp;Logout</a></li>
                    </ul>
            		</li>
      		</c:otherwise>
      	</c:choose>
      	</ul>
    </nav>
</div>


