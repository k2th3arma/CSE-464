<jsp:include page="../Shared/OwnerPartial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
</head>

<body id="back">
		<br>
		<br>
		
		<h2> Add Showroom</h2>
		
		<form action=../ShowroomServlet name="userForm" method="post" >
		
			Number of Seats: 	<input type=text name=seats> <br>
			Theatere: 		<select name=theatre>
								<c:forEach var="item" items="${theatres}">
									<option value="${item.theatreID}"> ${item.name}</option>							
								</c:forEach>						
							</select>
			<input hidden=true type=number name=id value=<%=session.getAttribute("userID")%>>
			
						
			
			<input type=submit value=Add> <br> 
		
		</form>
		</div>
		<br>
		<br>
		
	</body>
</html>