<jsp:include page="../Shared/OwnerPartial.jsp"></jsp:include>

<html>
<body id="back">
		<br>
		<br>
		
		<h2> Add Movie</h2>
		
		<div id="rcorners2" class="container2">
		<form action=../TheatreServlet name="userForm" method="post" >
		
			Theatre Name: 	<input type=text name=name> <br>
			Address: 		<input type=text name=address> <br>
			City: 		<input type=text name=city>				<br>
			State:  		<input type=text name=state> <br>
			Postal Code:  		<input type=number name=postal> <br>
			<input hidden=true type=number name=id value=<%=session.getAttribute("userID")%>>
						
			
			<input type=submit value=Add> <br> 
		
		</form>
		</div>
		<br>
		<br>
		
	</body>
</html>