<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Customer Home Page</title>
<html>
<body>

<h1> Customer Homepage</h1>

<h2> Welcome!</h2>

<br>

<div id="rcorners2" class="container2">
	<form action="../MovieQueryServlet" name="userForm" method="post" >
		Search Bar <input type=text name=search><br>
		Theatre: 		<select name=theatre>
								<c:forEach var="item" items="${theatres}">
									<option value="${item.theatreID}"> ${item.name}</option>							
								</c:forEach>						
							</select> <br>
		Date: <input type="date" name=date> <br>	
			
		<input type=submit value=Movie> <br> 
	</form>
</div>


</body>
</html>