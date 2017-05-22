<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <jsp:include page="common/head.jsp"></jsp:include>
   <link rel= "stylesheet" type="text/css" href="static/css/userpage_css.css">
   <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
   <script src="static/js/jquery.chart.js"></script>
   <script type="text/javascript">
   
$(function () {

    // Radialize the colors
    Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
        return {
            radialGradient: {
                cx: 0.5,
                cy: 0.3,
                r: 0.7
            },
            stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
            ]
        };
    });

    // Build the chart
    $('#jobCountChart').highcharts({
        chart: {
        	backgroundColor:'rgba(255, 255, 255, 0.0)',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Number of Job Positions by Recruiter',
            	style: {
                    color: '#ffffff',
                    font: 'bold 22px "Trebuchet MS", Verdana, sans-serif'
                }
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}% ({point.y})</b>'
        },
        plotOptions: {
            pie: {
            	size:'100%',
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f}% ({point.y})',
                    style: {
                        color: '#ffffff',
                        font: 'bold 18px "Trebuchet MS", Verdana, sans-serif'
                    },
                    connectorColor: 'silver'
                }
            }
        },
        credits: {
            enabled: false
        }
    });
    
    
    $('#failRateChart').highcharts({
        chart: {
        	backgroundColor:'rgba(255, 255, 255, 0.0)',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Your Interviews By Results',
            	style: {
                    color: '#ffffff',
                    font: 'bold 22px "Trebuchet MS", Verdana, sans-serif'
                }
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}% ({point.y})</b>'
        },
        plotOptions: {
            pie: {
            	size:'100%',
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f}% ({point.y})',
                    style: {
                        color: '#ffffff',
                        font: 'bold 18px "Trebuchet MS", Verdana, sans-serif'
                    },
                    connectorColor: 'silver'
                }
            }
        },
        credits: {
            enabled: false
        }
    });
    
    $('#typeChart').highcharts({
        chart: {
        	backgroundColor:'rgba(255, 255, 255, 0.0)',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Your Interviews By Type',
            	style: {
                    color: '#ffffff',
                    font: 'bold 22px "Trebuchet MS", Verdana, sans-serif'
                }
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}% ({point.y})</b>'
        },
        plotOptions: {
            pie: {
            	size:'100%',
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f}% ({point.y})',
                    style: {
                        color: '#ffffff',
                        font: 'bold 18px "Trebuchet MS", Verdana, sans-serif'
                    },
                    connectorColor: 'silver'
                }
            }
        },
        credits: {
            enabled: false
        }
    });
    
    

});
		</script>
<title>View Statistics</title>
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

	<script src="${pageContext.request.contextPath}/static/js/highcharts.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/exporting.js"></script>
	<h1>View Statistics</h1><br/>
		<script>
/* 		$(document).ready(function(){
			var chart = $('#jobCountChart').highcharts();
		    chart.addSeries({
		        name: 'Number of Job positions',
		        data: [
						<c:forEach var="jobstat" items="${postJobCount}" varStatus="jobCounter">
		               { name: '${jobstat.key}', y: Number('${jobstat.value}'), sliced: false, selected: false},
						</c:forEach>
		        ]
		    });
		}); */
		
		$(document).ready(function(){
			var chart = $('#failRateChart').highcharts();
		    chart.addSeries({
		        name: 'Number of Interviews',
		        data: [
						<c:forEach var="interviewstat" items="${interviewResultCount}" varStatus="interviewCounter">
		               { name: '${interviewstat.key}', y: Number('${interviewstat.value}'), sliced: false, selected: false},
						</c:forEach>
		        ]
		    });
		});
		
		$(document).ready(function(){
			var chart = $('#typeChart').highcharts();
		    chart.addSeries({
		        name: 'Number of Interviews',
		        data: [
						<c:forEach var="interviewstat" items="${interviewTypeCount}" varStatus="interviewCounter">
		               { name: '${interviewstat.key}', y: Number('${interviewstat.value}'), sliced: false, selected: false},
						</c:forEach>
		        ]
		    });
		});
		
		</script>
		
	     
		<table id="resultTable" class="table table-striped table-bordered display" name="resultStatsTable">
	   		<thead>
	          <tr>
	            <th>Result Type</th>
	            <th>Number of Interviews</th>
	          </tr>
	        </thead>
	        <tbody>
	          <c:forEach var="resultstat" items="${interviewResultCount}" varStatus="resultCounter">
	            <tr>
	              <td align="center">${resultstat.key}</td>
	              <td align="center">${resultstat.value}</td>
	            </tr>
	          </c:forEach>
	        </tbody>
	      </table>
	     
	     <div id="failRateChart"></div>
	     <br/>
	     <br/>
	     		<table id="typeTable" class="table table-striped table-bordered display" name="typeStatsTable">
	   		<thead>
	          <tr>
	            <th>Interview Type</th>
	            <th>Number of Interviews</th>
	          </tr>
	        </thead>
	        <tbody>
	          <c:forEach var="resultstat" items="${interviewTypeCount}" varStatus="resultCounter">
	            <tr>
	              <td align="center">${resultstat.key}</td>
	              <td align="center">${resultstat.value}</td>
	            </tr>
	          </c:forEach>
	        </tbody>
	      </table>
	     <div id="typeChart"></div>
	     <br/>
	     <br/>
	     
<%-- 	     <table id="jobTable" class="table table-striped table-bordered display" name="jobStatsTable">
	   		<thead>
	          <tr>
	            <th>Recruiter Name</th>
	            <th>Number of Posted Positions</th>
	          </tr>
	        </thead>
	        <tbody>
	          <c:forEach var="jobstat" items="${postJobCount}" varStatus="jobCounter">
	            <tr>
	              <td align="center">${jobstat.key}</td>
	              <td align="center">${jobstat.value}</td>
	            </tr>
	          </c:forEach>
	        </tbody>
	      </table>
	     <div id="jobCountChart"></div> --%>
	     <br/>
	</section>
</main>
            </div>
	<jsp:include page="footer.jsp"></jsp:include>          
        </div>
</div>


</body>
</html>