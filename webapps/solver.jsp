<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solver</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/Servlet" method="post">		
			<div><h2>Iterations:</h2></div>
			<div><textarea id="1" name="iterations" cols="50" rows="2"></textarea></div>
			<div><button type="submit" name="button" value="buttonCalc">Calculate</button></div>
		</form>
	</div>
</body>
</html>