<jsp:include page="Shared/Header.jsp"></jsp:include>

<html>	
	<script>
			function validateForm() {
				
			    var x = document.forms["userForm"]["userName"].value;
			    var y = document.forms["userForm"]["password"].value;
			    var z = document.forms["userForm"]["password2"].value;
			    var zip = document.forms["userForm"]["zip"].value;
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
			    
			    if(validateZip(zip) == false){
			    	alert("Zip Code is too short");
			    	return false;
			    }
			}
			function validateZip(zip){
				var count = zip.length;
				if(count < 5){
					return false;
				}else{
					return true;
				}
			}
	   </script>	   
	<body id="back">
		<br>
		<br>
		
		<h2> Register here</h2>
		
		<div id="rcorners2" class="container2">
		<form action	=Register name="userForm" onsubmit="return validateForm()" method="post" >
		
			First Name: 	<input type=text name=firstName> <br>
			Last Name: 		<input type=text name=lastName> <br>
			User Name: 		<input type=text name=userName>				<br>
			Password:  		<input type=password name=password id="one"> <br>
			Password:  		<input type=password name=password2 id="two"><br>
			Email: 			<input type=text name=email><br>
			Phone Number: 	<input type="number" name=phone><br>
			Address :		<input type=text name= address><br>
			City:			<input type=text name=city><br>
			State:			<input type=text name=state><br>
			Zip code			<input type=number name=zip><br>	
			User Type: 		<select name="type"> 
				<option>customer</option>
				<option>owner</option>
			</select> <br>		
						
			
			<input type=submit value=Register> <br> 
		
		</form>
		</div>
		<br>
		<br>
		
	</body>
</html>