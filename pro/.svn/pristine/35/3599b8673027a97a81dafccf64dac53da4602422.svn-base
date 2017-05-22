<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/login.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<header>
		<a href="index.html"><img id="Logo"></a>
		<div id="rightheadertop">
			<img id="Phone">
			<span id="phonenum">&nbsp Call TP 800 800 8000</span>
		</div>
		<div id="rightheaderbottom">
			<a href="LogOff"><input class="registerbutton" type="submit" id="loginbutt" value="LogOff"/></a>
			&nbsp
			<a href="TPregister"><input class="registerbutton" type="submit" id ="registerbutt" value="Register"/></a>
		</div>
	</header>
	<button onclick="window.location.href='ShRoleLog'">Go Back</button></br></br>
	${
	sessionScope.person}</br></br><br>

		<div class="input">
			<h1 class="sectionlabel">Make A Request</h1>
			<form class="request" id="requestform" method="post" action="RequestInfo">
			
				<select name="buyorsell" >
					<option value="BUY">BUY</option>
					<option value="SELL">SELL</option>
				</select><br><br>
				<input class="requestfieldtext" type="number" min="0" step="1" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must Be Integers' : '');" id="company" placeholder="Stock ID"  name="stockid" required> <br><br>
				<input class="requestfieldtext" type="number"  min="0" step="1" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must Be Integers' : '');" id="shares" placeholder="Shares" name="shares" required> <br><br>
				<input class="requestfieldtext" type="number"  min="0" step="1" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must Be Integers' : '');" id="minimum" placeholder="Minimum Shares" name="minimum" required> <br><br>
				
				<select name="timeinforce" >
					<option value="DAY ONLY">DAY ONLY</option>
					<option value="GOOD UNTIL CANCELLED">GOOD UNTIL CANCELLED</option>
					<option value="IMMEDIATE OR CANCEL">IMMEDIATE OR CANCEL</option>
				</select><br><br>
				
				<input class="requestfieldtext" type="text" value="null" id="limitprice" placeholder="Limit Price" name="limitprice" required> <br><br>
				<input class="requestfieldtext" type="text" value="null" id="stopprice" placeholder="Stop Price" name="stopprice" required> <br><br>
				

					
				<p class="checkboxtext"> <input class="checkboxlook" type="checkbox" value="confirm" required> Make This Request</p>
				<div id="requestbutt">
				<input class="loginbutton" type="submit" value="Make It"/>
				</div>
			</form>
		</div>

				<footer>
	<div class="footer-social">
		<li><a href="http://www.facebook.com">
        <img src='images/1444936871_facebook_online_social_media.png' style='height:25px; width:25px' />
		</a></li>
		<li><a href="http://www.twitter.com">
		<img src='images/1444936887_twitter_online_social_media.png' style='height:25px; width:25px' />
		</a></li>
		<li><a href="http://www.linkedin.com">
		<img src='images/1444936920_linked_in_online_social_media.png' style='height:25px; width:25px' />
		</a></li>
		<li><a href="http://www.plus.google.com">
		<img src='images/1444936908_google_plus_online_social_media.png' style='height:25px; width:25px' />
		</a></li>
		<li><a href="http://www.youtube.com">
		<img src='images/1444936931_youtube_you_tube_online_social_media.png' style='height:25px; width:25px' />
		</a></li>
		<span style="color:#696969; font-size: 12px;">&copy 2015 TP tradingplatform.com. All rights reserved.</span>
	</div>
	</footer>
	</body>


</body>
</html>