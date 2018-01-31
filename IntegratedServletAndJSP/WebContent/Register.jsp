<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="util.Utilities" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
	
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MVC Web Application</title>
	</head>
	<script>
			function validateForm() {
			    var x = document.forms["userForm"]["userName"].value;
			    var y = document.forms["userForm"]["password"].value;
			    var z = document.forms["userForm"]["password2"].value;
			    
			    if (x == "") {
			        alert("Username must be filled out");
			        return false;
			    }
			    
			    if (y == "") {
			        alert("Password must be filled out");
			        return false;
			    }
			    
			    if(y.localCompare(z) != 0){
			    	alert("Passwords don't match");
			    	return false;
			    }
			}
	   </script>
	   
	<body>
		
		<h1> A Simple MVC Web Application</h1>
		<h2> Register here</h2>
		<center>
		<form action	=Register name="userForm" onsubmit="return validateForm()" method="post">
		
			User Name: <input type=text name=userName><br>
			Password: <input type=password name=password id="one"><br>
			Password: <input type=password name=password2 id="two"><br>		
						
			
			<input type=submit value=Register> <br> 
		
		</form>
		</center>
		<br>
		<br>
		
		<!-- Navigation links --> 
		<a href="Welcome.jsp"> Home Page </a> <br>
		
	
	</body>
</html>