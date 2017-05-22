/**
 * 
 */

function showMessage(msg){
alert("Message: " + msg);
}

function print(min,max){
	var text = "";
	for(i = min; i<max; i++){
		if(i%2 ==0){
			text = text +i +"<br/>";
		}
	}
	
	document.writeln(text);
}

function showHide(id){
	var div =document.getElementById(id); 
	if (div.style.visibility =='visible')
		div.style.visibility ='hidden';
	else
		div.style.visibility ='visible';
	
}

function submitForm(){
	var qtf = document.getElementById('qTF');
	var qtfCopy = document.getElementById('qTFCopy');

	if (qtfCopy.value == 'test'){
		var form = document.getElementById('form1');
		form.submit();
	}
	else{
		qtfCopy.value = qtf.value;
		alert("Can not submit your query");
		console.log("This guys wanted to seach for inappropraite word.");
	}
}

function checkVar(){
	var i = 10;
	var i2 = "10";
	
	if (i === i2)
		alert("Equal!");
	else
		alert("Not Equal");
}

function changeParagraph(){
	var p1 = document.getElementById("p1");
	p1.innerHTML ="<strong>I changed this <em>paragraph</em></strong>";
}