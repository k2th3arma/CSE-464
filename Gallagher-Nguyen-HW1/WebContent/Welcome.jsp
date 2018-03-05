
<jsp:include page="Shared/Header.jsp"></jsp:include>

<html>
	<script type=text/javascript>
			function validateForm() {
			    var x = document.forms["userForm"]["userName"].value;
			    var y = document.forms["userForm"]["password"].value;
			    if (x == "") {
			        alert("Username must be filled out");
			        return false;
			    }
			    
			    if (y == "") {s
			        alert("Password must be filled out");
			        return false;
			        
			    }
			}
	</script>   	
	<body id="back">
		<br>
		<br>
		
		<h2> Login here</h2>
		<div id="rcorners2" >
		<form name="userForm" action=Login 
		      onsubmit="return validateForm()" method="post">
		
			User Name: <input type=text name=userName>		<br>
			Password:  <input type=password name=password>	<br>
			Remember Me? <input type="checkbox" name=persist> <br>
			
			<input type=submit value=Login> <br>  		
		</form>
		</div>
		<br>
		<br>
	
	</body>
	
	
</html>