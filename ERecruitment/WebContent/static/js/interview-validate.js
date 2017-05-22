$(document).ready(function() {
	$('#createInterviewForm').submit(function(event) {
		if(!checkDate()){
			console.log("check interview date is false");
			event.preventDefault();
		}
	});
});

function checkDate() {
    var d = new Date();
   
    var day = d.getDate();
    var month = d.getMonth()+1;
    var year = d.getFullYear();
   
    var date = $("#date").val();
    
    var date1 = date.split("-");
    var sYear = date1[0];
    var sMonth = date1[1];
    var sDay = date1[2];
    
    if(year>sYear){
    	alert("Interview year should be greater than the current year");
    	return false;
    }
    else if(month>sMonth && year==sYear){
    	alert("Interview month should be greater than the current month");
    	return false;
    }
    else if(day>sDay && month==sMonth && year==sYear){
    	alert("Interview date should be greater than the current date");
    	return false;
    }
    else
    	return true;
}