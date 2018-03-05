<jsp:include page="../Shared/OwnerPartial.jsp"></jsp:include>
<html>
<body id="back">
		<br>
		<br>
		
		<h2> Add Movie</h2>
		
		<div id="rcorners2" class="container2">
		<form action=../MovieServlet name="userForm" method="post" >
		
			Movie Name: 	<input type=text name=movie> <br>
			Description: 		<input type=text name=description> <br>
			Thumbnail: 		<input type="file" name=thumbnail>				<br>
			Rating:  		<input type=number name=rating> <br>
			
						
			
			<input type=submit value=Add> <br> 
		
		</form>
		</div>
		<br>
		<br>
		
	</body>
</html>