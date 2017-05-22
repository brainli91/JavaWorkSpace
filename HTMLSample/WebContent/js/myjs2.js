
$(document).ready(function(){
	
	var flag = true;
	
	$("#b2").click(function(){
		$("#qTFCopy").val($("#qTF").val())
	});
/*	.keydown release the info */
	$("#qTF").keyup(function(){
		$("#p1").html($("#qTF").val());
	});
	
	$("#b1").click(function(){
		if (flag){
			//$("#div1").hide();
			$("#div1").fadeOut();
			
			flag =false;
			
		}
		else{
			//$("#div1").show();
			$("#div1").fadeIn();
			$("#div1").css("background-color","red");
			flag =true;
		}
	});
	
	$("#b3").click(function(){
		if(flag){
			for(var i=0; i<100; i++){
				$("#prg1").animate({value: "+=1"},1);
	
			}
			flag =false;
		}
		else{
			for(var i=0; i<100; i++){
				$("#prg1").animate({value: "-=1"},1);
			
			}
			flag =true;
		}
		//$("#prg1").attr("value","50");
	});
	
	$("#b4").click(function(){
		
		var vRegExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        var value = $("#emailTF").val();
        
       if (RegExp(vRegExp).test(value))
           alert('Correct Email!!!');
       else 
        alert('Wrong Email!!!');

	});
});

