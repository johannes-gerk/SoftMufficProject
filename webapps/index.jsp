<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SoftMuffinProject</title>
</head>
<body>
<div><img src="resources/muffincat.png"></div>
<div><a href="/solver.jsp" class="btn btn-default">Solver</a></div>
<div><h1><% out.println("How to set up project:"); %></h1>
<h2><% out.println("1. get <a href=\"https://www.eclipse.org/\">Eclipse</a>"); %></h2>
<h2><% out.println("2. get <a href=\"https://desktop.github.com/\">Git-Desktop</a>"); %></h2>
<h2><% out.println("3. in Git-Desktop clone repo from URL https://github.com/johannes-gerk/SoftMuffinProject.git"); %></h2>
<h2><% out.println("(need to add Contributors in GitHub)"); %></h2>
<h2><% out.println("4. import to Eclipse from File System (./Documents/GitHub/ProjectName)"); %></h2>
<h2><% out.println("if errors:"); %></h2>
<h2><% out.println("Download/Install <a href=\"http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html\">JDK 8u162</a>"); %></h2>
<h2><% out.println("Download/Install <a href=\"https://tomcat.apache.org/download-90.cgi\">Apache Tomcat 9</a>"); %></h2>
<h2><% out.println("Add Apache Server to Eclipse: Go to Windows - Preferences, Server, Runtime Environments, Add, Select Apache 9, specify local Path"); %></h2>
<h2><% out.println("right-click Project - Properties, Java Build Path, Libraries Tab and provide necessary paths for Server/JRE"); %></h2>
</div>
</body>
</html>