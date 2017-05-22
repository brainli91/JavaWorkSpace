$(document).ready(function() {
	$('#createJobForm').submit(function(event) {
		
		if(!checkStartDate()){
			console.log("checkstart date is false");
			event.preventDefault();
		}
		if (!checkDeadline()) {
			console.log("check deadline date is false");
			event.preventDefault();
		} else {
			if(!checkStartAndDeadline()) {
				console.log("check start and deadline date is false");
				event.preventDefault();
			} else {
				console.log("it is true")
			}
		}

	});
});

function checkStartDate() {
	    var d = new Date();
	   
	    var day = d.getDate();
	    var month = d.getMonth()+1;
	    var year = d.getFullYear();
	    
	    var startDate = $("#startDate").val();
	    var date1 = startDate.split("-");
	    var sYear = date1[0];
	    var sMonth = date1[1];
	    var sDay = date1[2];
	  
	   /* if(sMonth<10) {
	    	var sMonth = sMonth.substring(1);
	    }
	    if(sDay<10) {
	    	var sDay = sDay.substring(1);
	    }*/
	   
	    if(year<=sYear){
	    	if (year==sYear) {
	    		if(month<=sMonth){
	    			if (month==sMonth) {
	    				if(day<=sDay){
			    			return true;
			    		
			    		}
			    		else{
			    	    	alert("Start date should be greater than current date");
			    	    	
			    	    }
	    			} else {
	    				return true;
	    			}
		    		
		    	} else{
			    	alert("Start month should be greater than current date");
			    }
		    	
	    	} else {
	    		return true;
	    	}
	    	
	    } else{
	    	alert("Start year should be greater than current date");
	    }
	    
	    return false;
	}

function checkDeadline() {
    var d = new Date();
   
    var day = d.getDate();
    var month = d.getMonth()+1;
    var year = d.getFullYear();
   
    var deadline = $("#deadline").val();
    console.log(deadline);
    var date1 = deadline.split("-");
    var sYear = date1[0];
    var sMonth = date1[1];
    var sDay = date1[2];
    
    if(year<=sYear){
    	if (year==sYear) {
    		if(month<=sMonth){
    			if (month==sMonth) {
    				if(day<=sDay){
		    			return true;
		    		
		    		}
		    		else{
		    	    	alert("Deadline date should be greater than current date");
		    	    	
		    	    }
    			} else {
    				return true;
    			}
	    		
	    	} else{
		    	alert("Deadline month should be greater than current date");
		    }
	    	
    	} else {
    		return true;
    	}
    	
    } else{
    	alert("Deadline year should be greater than current date");
    }
    
    return false;
}

function checkStartAndDeadline() {
	var startDate = $("#startDate").val();
	var deadline = $("#deadline").val();
	
	 var deadline = deadline.split("-");
	    var dYear = deadline[0];
	    var dMonth = deadline[1];
	    var dDay = deadline[2];
	    
	    var startDate = startDate.split("-");
	    var sYear = startDate[0];
	    var sMonth = startDate[1];
	    var sDay = startDate[2];
	    if(dYear<=sYear){
	    	if (dYear==sYear) {
	    		if(dMonth<=sMonth){
	    			if (dMonth==sMonth) {
	    				if(dDay<sDay){
			    			return true;
			    		}
			    		else{
			    	    	alert("Start date should be greater than deadline date");
			    	    	
			    	    }
	    			} else {
	    				return true;
	    			}
		    		
		    	} else{
			    	alert("Start month should be greater than deadline date");
			    }
	    	} else {
	    		return true;
	    	}
	    	
	    	
	    } else{
	    	alert("Start year should be greater than deadline date");
	    }
	    
	    return false;
}









