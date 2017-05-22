$(document).ready(function() {
	$("input[name='formChoice']").change(function() {
		if($("#uploadResumeRadio").is(":checked")) {
			$("#uploadResumeForm").show();
			$("#profileForm").hide();
		}
		else if($("#fillInFieldsRadio").is(":checked")) {
			$("#profileForm").show();
			$("#uploadResumeForm").hide();
		}
	});
	
	$("#addEducationButton").click(function(){
		var button = $("#addEducationButton");
		var count = $("#educationList").children().length - 1;
		var educationFields = "<br/><div class='errorMessage alert alert-danger login-box' style='display: none' id='sendEdErrors[" + count +"]'><div class='glyphicon glyphicon-remove-circle'></div></div> <div class='education' id='education[" + count + "]'>" +
							  	"<h4>Education&nbsp</h4>" +
							  	 "<div id='editEducationDiv[" + count +"]'>" +
							     "</div>"+
							     "<input type='hidden' id='educationId[" + count +"]' value='0'>"+
						  		"<div class='form-group'>" +
						  			"<label for='institution["+count+"]'>Institution</label>" +
						  			"<input type='text' id='institution["+count+"]' name='institution' placeholder='College/University' />" +
					  			"</div>" +
					  			"<div class='form-group'>" +
						  			"<label for='startDate["+count+"]'>Start Date</label>" +
						  			"<input type='date' id='startDate["+count+"]' name='startDate' />" +
					  			"</div>" +
					  			"<div class='form-group'>" +
						  			"<label for='endDate["+count+"]'>End Date</label>" +
						  			"<input type='date' id='endDate["+count+"]' name='endDate' />" +
					  			"</div>" +
					  			"<div class='form-group'>" +
						  			"<label for='degree["+count+"]'>Degree</label>" +
						  			"<input type='text' id='degree["+count+"]' name='degree' placeholder='Degree' />" +
					  			"</div>" +
					  			"<div class='form-group'>" +
						  			"<label for='program["+count+"]'>Program</label>" +
						  			"<input type='text' id='program["+count+"]' name='program' placeholder='Program' />" +
					  			"</div>" +
					  			"<div id='sendEducationButton["+count+"]'>"+
					  				"<button type='button' class='sendEducationButton' onclick='sendEducation("+count+")'>Save</button>" +
					  			"</div>"+
				  			  "</div>";
		
		$("#educationList").remove("#addEducationButton");
		$("#educationList").append(educationFields);
		$("#educationList").append(button);
	});

	$("#addWorkHistoryButton").click(function(){
		var button = $("#addWorkHistoryButton");
		var count = $("#workHistoryList").children().length - 1;
		var workHistoryFields = "<br/><div class='errorMessage alert alert-danger login-box' style='display: none' id='workHisErrors[" + count +"]'><div class='glyphicon glyphicon-remove-circle'></div></div> <div class='workHistory' id='workHistory[" + count + "]'>" +
									"<h4 style='display:inline'>Job&nbsp</h4>" +
							        "<div id='editWorkDiv[" + count +"]'>" +
							        "</div>"+
							    "<input type='hidden' id='workHistoryId[" + count +"]' value='0'>"+
						  		"<div class='form-group'>" +
						  			"<label for='employer["+count+"]'>Employer</label>" +
						  			"<input type='text' id='employer["+count+"]' name='Employer' placeholder='Employer' />" +
					  			"</div>" +
					  			"<div class='form-group'>" +
						  			"<label for='startDateWork["+count+"]'>Start Date</label>" +
						  			"<input type='date' id='startDateWork["+count+"]' name='startDate' />" +
					  			"</div>" +
					  			"<div class='form-group'>" +
						  			"<label for='endDateWork["+count+"]'>End Date</label>" +
						  			"<input type='date' id='endDateWork["+count+"]' name='endDate' />" +
					  			"</div>" +
					  			"<div class='form-group'>" +
						  			"<label for='title["+count+"]'>Job Title</label>" +
						  			"<input type='text' id='title["+count+"]' name='Title' placeholder='Job Title' />" +
					  			"</div>" +
					  			"<div class='form-group'>" +
						  			"<label for='description["+count+"]'>Description</label>" +
						  			"<textarea id='description["+count+"]' name='description' placeholder='Description' rows='3'></textarea>" +
					  			"</div>" +
					  			"<div id='sendWorkHistoryButton["+count+"]'>"+
					  				"<button type='button' class='sendWorkHistoryButton' onclick='sendWorkHistory("+count+")'>Save</button>" +
					  			"</div>"+
					  			"</div>";
		
		$("#workHistoryList").remove("#addWorkHistory");
		$("#workHistoryList").append(workHistoryFields);
		$("#workHistoryList").append(button);
	});
	
	
	$("#addSkillFieldButton").click(function(){
		
		var button = $("#addSkillFieldButton");
		var count = $("#skillsList").children().length;
		var skillErrors = "";
		
		if($("#skillField").val().length==0){
			skillErrors += "<li>Skill field must not be empty</li>";
			document.getElementById("skillField").style.backgroundColor = "#f2dede";
			$('#skillErrors').html(skillErrors);
			return;
		} else if($("#skillField").val().length > 24) {
			skillErrors += "<li>Skill field must be less than 24 characters</li>";
			document.getElementById("skillField").style.backgroundColor = "#f2dede";
			$('#skillErrors').html(skillErrors);
			return;
		} else {
			document.getElementById("skillField").style.backgroundColor = "#FFFFFF";
		}
		
		sendSkill($("#skillField").val(), count)
		
		
		$("#skillsList").append("<div class='singleSkill' id='singleSkill["+count+"]'>"+$("#skillField").val()+" <span class='glyphicon glyphicon-remove' onclick='deleteSkill(\""+$("#skillField").val()+"\", "+count+")' aria-hidden='true'></span></div>");
		$("#skillField").val("");
		$("#skillsList").append($("#skillField"));
		$("#skillsList").append(button);
		
		
	});
	
	$("#addInterestFieldButton").click(function(){
		
		var button = $("#addInterestFieldButton");
		var count = $("#InterestsList").children().length;
		var interestErrors = "";
		
		if($("#interestField").val().length==0){
			interestErrors += "<li>Interest field must not be empty</li>";
			document.getElementById("interestField").style.backgroundColor = "#f2dede";
			$('#interestErrors').html(interestErrors);
			return;
		} else if($("#interestField").val().length > 24) {
			interestErrors += "<li>Interest field must be less than 24 characters</li>";
			document.getElementById("interestField").style.backgroundColor = "#f2dede";
			$('#interestErrors').html(interestErrors);
			return;
		} else {
			document.getElementById("interestField").style.backgroundColor = "#FFFFFF";
		}
		
		sendInterest($("#interestField").val(), count)
		
		
		$("#interestsList").append("<div class='singleInterest' id='singleInterest["+count+"]'>"+$("#interestField").val()+" <span class='glyphicon glyphicon-remove' onclick='deleteInterest(\""+$("#interestField").val()+"\", "+count+")' aria-hidden='true'></span></div>");
		$("#interestField").val("");
		$("#interestsList").append($("#interestField"));
		$("#interestsList").append(button);
		
		
	});
	
	$("#profileForm").submit(function(event) {
		var errors = "";
		
		if($("#address").val().length > 48) {
			errors += "<li>Address cannot contain more than 48 characters</li>";
			event.preventDefault();
		}
		if($("#primaryPhone").val().length > 16) {
			errors += "<li>Primary phone number is not in the correct format</li>";
			event.preventDefault();
		}
		if($("#secondaryPhone").val().length > 16) {
			errors += "<li>Secondary phone number is not in the correct format</li>";
			event.preventDefault();
		}
		if (errors && errors.length > 0) {
			$('#errors').show();
			$('#errors').html(errors);
			event.preventDefault();
		}
		
	});
	
	
});

function sendEducation(index){
	var inst = document.getElementById("institution["+index+"]").value;
	var sDate = document.getElementById("startDate["+index+"]").value;
	var eDate = document.getElementById("endDate["+index+"]").value;
	var deg = document.getElementById("degree["+index+"]").value;
	var prog = document.getElementById("program["+index+"]").value;
	var saveButton = document.getElementById("sendEducationButton["+index+"]");
	var editEducation = document.getElementById("editEducationDiv[" + index +"]");
	var sendEdErrors = "";
	
	if(inst.length == 0) {
		sendEdErrors += '<li>Institution must be filled</li>';
	}
	else if(inst.length > 24) {
		sendEdErrors += '<li>Institution cannot be longer than 24 characters</li>';
	}
	
	if(sDate.length == 0) {
		sendEdErrors += '<li>Start Date must be filled</li>';
	}
	
	if(eDate.length == 0) {
		sendEdErrors += '<li>End Date must be filled</li>';
	}
	
	if(validateDates(sDate, eDate)) {
		sendEdErrors += '<li>Start Date must be earlier than End Date</li>';
	}

	if(deg.length == 0) {
		sendEdErrors += '<li>Degree must be filled</li>';
	}
	else if(deg.length > 7) {
		sendEdErrors += '<li>Degree cannot be longer than 24 characters</li>';
	}
	
	if(prog.length == 0) {
		sendEdErrors += '<li>Program must be filled</li>';
	}
	else if(prog.length > 24) {
		sendEdErrors += '<li>Program cannot be longer than 24 characters</li>';
	}

	if (sendEdErrors && sendEdErrors.length > 0) {
		document.getElementById("sendEdErrors[" + index +"]").innerHTML = sendEdErrors;
		document.getElementById("sendEdErrors[" + index +"]").style.display = "block";
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "createEducation",
		data: {institution: inst, startDate: sDate, endDate: eDate, degree: deg, program: prog},
		success: function(data) {
			document.getElementById("educationId["+index+"]").value = data;
			document.getElementById("institution["+index+"]").disabled = true;
			document.getElementById("startDate["+index+"]").disabled = true;
			document.getElementById("endDate["+index+"]").disabled = true;
			document.getElementById("degree["+index+"]").disabled = true;
			document.getElementById("program["+index+"]").disabled = true;
			saveButton.innerHTML = "<span class='glyphicon glyphicon-ok' aria-hidden='true'></span>";
			editEducation.innerHTML = "<span id='editButtonEducation[" + index +"]' class='glyphicon glyphicon-cog' aria-hidden='true' onClick='makeEditableEducation(" + index +")'>"
		},
		error: function(e){
			alert("Error");
		}
		
	});
}

function sendWorkHistory(index){
	var empl = document.getElementById("employer["+index+"]").value;
	var sDate = document.getElementById("startDateWork["+index+"]").value;
	var eDate = document.getElementById("endDateWork["+index+"]").value;
	var jtitle = document.getElementById("title["+index+"]").value;
	var desc = document.getElementById("description["+index+"]").value;
	var saveButton = document.getElementById("sendWorkHistoryButton["+index+"]");
	var editWorkHistory = document.getElementById("editWorkDiv[" + index +"]");
	var workHisErrors = "";
	
	if(empl.length == 0) {
		workHisErrors += '<li>Employer must be filled</li>';
	}
	else if(empl.length > 24) {
		workHisErrors += '<li>Employer cannot be longer than 24 characters</li>';
	}
	
	if(sDate.length == 0) {
		workHisErrors += '<li>Start Date must be filled</li>';
	}
	
	if(eDate.length == 0) {
		workHisErrors += '<li>End Date must be filled</li>';
	}
	
	if(validateDates(sDate, eDate)) {
		workHisErrors += '<li>Start Date must be earlier than End Date</li>';
	}

	if(jtitle.length == 0) {
		workHisErrors += '<li>Job Title must be filled</li>';
	}
	else if(jtitle.length > 24) {
		workHisErrors += '<li>Job Title cannot be longer than 24 characters</li>';
	}
	
	if(desc.length == 0) {
		workHisErrors += '<li>Description must be filled</li>';
	}
	else if(desc.length > 255) {
		workHisErrors += '<li>Description cannot be longer than 255 characters</li>';
	}

	if (workHisErrors && workHisErrors.length > 0) {
		document.getElementById("workHisErrors[" + index +"]").innerHTML = workHisErrors;
		document.getElementById("workHisErrors[" + index +"]").style.display = "block";
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "createWorkHistory",
		data: {employer: empl, startDate: sDate, endDate: eDate, title: jtitle, description: desc},
		success: function(data) {
			document.getElementById("workHistoryId["+index+"]").value = data;
			document.getElementById("employer["+index+"]").disabled = true;
			document.getElementById("startDateWork["+index+"]").disabled = true;
			document.getElementById("endDateWork["+index+"]").disabled = true;
			document.getElementById("title["+index+"]").disabled = true;
			document.getElementById("description["+index+"]").disabled = true;
			saveButton.innerHTML = "<span class='glyphicon glyphicon-ok' aria-hidden='true'></span>";
			editWorkHistory.innerHTML = "<span id='editButtonWork[" + index +"]' class='glyphicon glyphicon-cog' aria-hidden='true' onClick='makeEditableWork(" + index +")'>"
		},
		error: function(e){
			alert("Error "+ e);
		}
		
	});
}


function makeEditableWork(index){
	document.getElementById("employer["+index+"]").disabled = false;
	document.getElementById("startDateWork["+index+"]").disabled = false;
	document.getElementById("endDateWork["+index+"]").disabled = false;
	document.getElementById("title["+index+"]").disabled = false;
	document.getElementById("description["+index+"]").disabled = false;
	
	var editButtonToRemove = document.getElementById("editButtonWork["+index+"]");
	editButtonToRemove.parentNode.removeChild(editButtonToRemove);
	
	var checkMarkToRemove = document.getElementById("sendWorkHistoryButton["+index+"]");
	checkMarkToRemove.innerHTML='<button type="button" id="updateWork['+index+']" onclick="updateWork('+index+')">'+"Update work"+'</button>';
	
}

function makeEditableEducation(index){
	document.getElementById("institution["+index+"]").disabled = false;
	document.getElementById("startDate["+index+"]").disabled = false;
	document.getElementById("endDate["+index+"]").disabled = false;
	document.getElementById("degree["+index+"]").disabled = false;
	document.getElementById("program["+index+"]").disabled = false;
	
	var editButtonToRemove = document.getElementById("editButtonEducation["+index+"]");
	editButtonToRemove.parentNode.removeChild(editButtonToRemove);
	
	var checkMarkToRemove = document.getElementById("sendEducationButton["+index+"]");
	checkMarkToRemove.innerHTML='<button type="button" id="updateEducation['+index+']" onclick="updateEducation('+index+')">'+"Update education"+'</button>';
	
}



function updateWork(index){
	
	var id = document.getElementById("workHistoryId["+index+"]").value;
	var empl = document.getElementById("employer["+index+"]").value;
	var sDate = document.getElementById("startDateWork["+index+"]").value;
	var eDate = document.getElementById("endDateWork["+index+"]").value;
	var jtitle = document.getElementById("title["+index+"]").value;
	var desc = document.getElementById("description["+index+"]").value;
	var saveButton = document.getElementById("sendWorkHistoryButton["+index+"]");
	var editWorkHistory = document.getElementById("editWorkDiv[" + index +"]");
	
	$.ajax({
		type: "POST",
		url: "editWorkHistory",
		data: {workId: id, employer: empl, startDate: sDate, endDate: eDate, title: jtitle, description: desc},
		success: function(data) {
			document.getElementById("employer["+index+"]").disabled = true;
			document.getElementById("startDateWork["+index+"]").disabled = true;
			document.getElementById("endDateWork["+index+"]").disabled = true;
			document.getElementById("title["+index+"]").disabled = true;
			document.getElementById("description["+index+"]").disabled = true;
			saveButton.innerHTML = "<span class='glyphicon glyphicon-ok' aria-hidden='true'></span>";
			editWorkHistory.innerHTML = "<span id='editButtonWork[" + index +"]' class='glyphicon glyphicon-cog' aria-hidden='true' onClick='makeEditableWork(" + index +")'>"
		},
		error: function(e){
			alert("Error "+ e);
		}
		
	});
	
}

function updateEducation(index){
	
	var id = document.getElementById("educationId["+index+"]").value;
	var inst = document.getElementById("institution["+index+"]").value;
	var sDate = document.getElementById("startDate["+index+"]").value;
	var eDate = document.getElementById("endDate["+index+"]").value;
	var deg = document.getElementById("degree["+index+"]").value;
	var prog = document.getElementById("program["+index+"]").value;
	var saveButton = document.getElementById("sendEducationButton["+index+"]");
	var editEducation = document.getElementById("editEducationDiv[" + index +"]");
	
	
	$.ajax({
		type: "POST",
		url: "editEducation",
		data: {educationId:id, institution: inst, startDate: sDate, endDate: eDate, degree: deg, program: prog},
		success: function(data) {
			document.getElementById("institution["+index+"]").disabled = true;
			document.getElementById("startDate["+index+"]").disabled = true;
			document.getElementById("endDate["+index+"]").disabled = true;
			document.getElementById("degree["+index+"]").disabled = true;
			document.getElementById("program["+index+"]").disabled = true;
			saveButton.innerHTML = "<span class='glyphicon glyphicon-ok' aria-hidden='true'></span>";
			editEducation.innerHTML = "<span id='editButtonEducation[" + index +"]' class='glyphicon glyphicon-cog' aria-hidden='true' onClick='makeEditableEducation(" + index +")'>"
		},
		error: function(e){
			alert("Error "+ e);
		}
		
	});
	
}


function sendSkill(newSkill, count){
	$.ajax({
		type: "POST",
		url: "createSkill",
		data : {skill: newSkill},
		success: function(data) {
			
		},
		error: function(e){
			
		}
	})
}

function deleteSkill(value, index){
	var skillToRemove = document.getElementById("singleSkill["+index+"]");
	$.ajax({
		type: "POST",
		url: "removeSkill",
		data : {toRemove: value},
		success: function(data) {
			skillToRemove.parentNode.removeChild(skillToRemove);
		},
		error: function(e){
			
		}
	})
}

function sendInterest(newInterest, count){
	$.ajax({
		type: "POST",
		url: "createInterest",
		data : {interest: newInterest},
		success: function(data) {
			
		},
		error: function(e){
			
		}
	})
}

function deleteInterest(value, index){
	var interestToRemove = document.getElementById("singleInterest["+index+"]");
	$.ajax({
		type: "POST",
		url: "removeInterest",
		data : {toRemove: value},
		success: function(data) {
			interestToRemove.parentNode.removeChild(interestToRemove);
		},
		error: function(e){
			
		}
	})
}

function validateDates(startDate, endDate) {
	
	 var ed = endDate.split("-");
	    var eYear = ed[0];
	    var eMonth = ed[1];
	    var eDay = ed[2];
	    
	    var sd = startDate.split("-");
	    var sYear = sd[0];
	    var sMonth = sd[1];
	    var sDay = sd[2];
	    console.log("in check start and deadline");
	    
	    if(eYear>sYear){
	    	alert("End year should be greater than the start year");
	    	return false;
	    }
	    else if(eMonth>sMonth && eYear == sYear){
	    	alert("End month should be greater than the start month");
	    	return false;
	    }
	    else if(eDay>sDay && eMonth == sMonth && eYear == sYear){
	    	alert("End date should be greater than the start date");
	    	return false;
	    }
	    else
	    	return true;
}