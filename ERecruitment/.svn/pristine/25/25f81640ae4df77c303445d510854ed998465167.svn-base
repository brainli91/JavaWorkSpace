$(document).ready(function() {
	$('#createUserForm').submit(function(event) {

		var email = $('#email').val();
	
		var errors = '';
		var vRegExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/gi;
		 
		var email = $("#email").val().trim();
		
		if($('#email').val().length > 64) {
			errors += '<li>Email cannot be longer than 64 characters</li>';
		}else if(!vRegExp.test(email)){
			errors += '<li>Email is not in the correct format</li>';
		}
		
		if (errors && errors.length > 0) {
			$('#errors').show();
			$('#errors').html(errors);
			event.preventDefault();
		}
		
	});
});
