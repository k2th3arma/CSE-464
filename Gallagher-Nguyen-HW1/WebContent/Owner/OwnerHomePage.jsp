<jsp:include page="../Shared/OwnerPartial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<body id="back">
	<br>
	<br>
	<li><a href="../MovieServlet">Add Movie</a>
	<li>
	<li><a href="AddTheatre.jsp">Add Theatre</a>
	<li>
	<li><a href="../ShowroomServlet">Add Showroom</a>
	<li><br> <br>

		<h2>Add Showtime</h2>

		<div id="rcorners2" class="container2">
			<form action=../MovieShowingsServlet name="userForm" method="get">
				Theatere: 		<select name=theatre>
								<c:forEach var="item" items="${theatres}">
									<option value="${item.theatreID}"> ${item.name}</option>							
								</c:forEach>						
							</select>
				<input hidden=true type=number name=id
					value=<%=session.getAttribute("userID")%>> <input
					type=submit value="Add Showing"> <br>

			</form>
		</div> <br> <br>
</body>
</html>