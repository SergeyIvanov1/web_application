<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Prologue</h1>
<p>You are standing at the space port and you are reading up of your sheep board. Do you dreamed about this?</p>
<p>Became of captain galactic sheep, which make honors ander of your </p>
You are standing at the spaceport and you are ready up of your shipboard. Do you dreamed about this?</p>
<p>To became of captain galactic ship, which make exploits under of your commands. Let's go!
<br><br>
<h1>Getting to know the crew:</h1>
<p>When you boarded, you were greeted by a girl with a black stick in her hands:</p>
<p>- Hello commander, I am Zinaida - your assistant.</p>
<p>There's your navigator, Sergeant Popov, drinking coffee in the corner,</p>
<p>and your flight mechanic is sleeping under the wheel. And how to contact you?</p>
<br><br>

<form action="questions" method="GET">
    Introduce yourself: <input name="visitorName" required/>
    <br><br>
    <input type="submit" value="Submit" />
</form>
<br><br>
<form action="remove_attribute" method="GET">
    <p>Remove attribute "visitor" from session:</p>
    <input type="submit" value="Submit" />
</form>


</body>
</html>
