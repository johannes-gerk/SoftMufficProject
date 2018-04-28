<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solver</title>
</head>
<body>
	<div id="createmeeting">
		<form action="${pageContext.request.contextPath}/Servlet" method="post">		
			<h2>Iterations:</>
			<textarea name="iterations" cols="50" rows="2"></textarea>
			<button type="submit" name="button" value="buttonCalc">Calculate</button>
		</form>
	</div>
</body>
</html>