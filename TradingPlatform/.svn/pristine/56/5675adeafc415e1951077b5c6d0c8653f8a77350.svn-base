/**
 * 
 */
$(document).ready(function(){
    $('.modal-footer button').click(function(){
		var button = $(this);

		if ( button.attr("data-dismiss") != "modal" ){
			var inputs = $('form input');
			var title = $('.modal-title');
			var progress = $('.progress');
			var progressBar = $('.progress-bar');

			inputs.attr("disabled", "disabled");

			button.hide();

			progress.show();

			progressBar.animate({width : "100%"}, 100);

			progress.delay(1000)
					.fadeOut(600);

			button.text("Close")
					.removeClass("btn-primary")
					.addClass("btn-success")
    				.blur()
					.delay(1600)
					.fadeIn(function(){
						title.text("Log in is successful");
						button.attr("data-dismiss", "modal");
					});
		}
	});

$('#myModal').on('hidden.bs.modal', function (e) {
		var inputs = $('form input');
		var title = $('.modal-title');
		var progressBar = $('.progress-bar');
		var button = $('.modal-footer button');

		inputs.removeAttr("disabled");

		title.text("Log in");

		progressBar.css({ "width" : "0%" });

		button.removeClass("btn-success")
				.addClass("btn-primary")
				.text("Ok")
				.removeAttr("data-dismiss");

	});


});


function editUser(id, username, password, firstname, lastname)
{

	el = document.getElementById("overlay");
	el.style.visibility = (el.style.visibility == "visible") ? "hidden" : "visible";
};
    
$('#editModal2').on('click', function() {
    var myModal = $('#myModal2');

    
    // now get the values from the table
/*    var userName = $(this).closest('tr').find('td.userName').html();
    var passWord = $(this).closest('tr').find('td.passWord').html();*/
/*    var firstName = $(this).closest('tr').find('td.firstName').html();
    var lastName = $(this).closest('tr').find('td.lastName').html();*/
    

    // and set them in the modal:
/*    $('.userName', myModal).val(userName);
    $('.passWord', myModal).val(passWord);*/
    $('.firstName', myModal).val(firstName);
    $('.lastName', myModal).val(lastName);

    

    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});
    
    
    
    