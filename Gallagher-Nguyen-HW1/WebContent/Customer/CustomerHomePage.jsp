<jsp:include page="../Shared/Partial.jsp"></jsp:include>

<title>Customer Home Page</title>
<html>
<body>

<h1> Customer Homepage</h1>

<h2> Welcome!</h2>

<br>

<div id="rcorners2" class="container2">
	<form action="../MovieServlet" name="userForm" method="get" >
		Search Bar <input type=text name=Search><br>
		Search Type <select name=type> 
			<option>Title</option>
			<option>Year</option>
			<option>Length</option>
			<option>MPAA</option>
			<option>Genre</option>
			<option>Theatre</option>
			<option>Showroom</option>
			</select> <br>
		<input type=submit value=Movie> <br> 
	</form>
</div>
		



</body>
</html>