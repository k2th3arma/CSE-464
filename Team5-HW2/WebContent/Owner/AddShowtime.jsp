<jsp:include page="../Shared/OwnerPartial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>


<body id="back">
	<br>
	<br>

		<h2>Add Showtime</h2>

		<div id="rcorners2" class="container2">
			<form action=../MovieShowingsServlet name="userForm" method="post">
				Price: <input type=text name=price> <br>
				Start Time: <input type="datetime-local" name=startTime> <br>
				End Time: <input type="datetime-local" name=endTime> <br>
				Movie: 		<select name=movie>
								<c:forEach var="item" items="${movies}">
									<option value="${item.movieID}"> ${item.title}</option>							
								</c:forEach>						
							</select>
				Showroom: 		<select name=theatre>
								<c:forEach var="item" items="${showrooms}">
									<option value="${item.showroomID}"> ${item.seats} </option>							
								</c:forEach>						
							</select>
				<input hidden=true type=number name=id
					value=<%=session.getAttribute("userID")%>> <input
					type=submit value="Add Showing"> <br>

			</form>
		</div> <br> <br>
</body>
</html>