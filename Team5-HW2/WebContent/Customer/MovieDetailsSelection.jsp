<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Movie Details</title>
</head>
<body>
	
	<br>
	
	
	<c:forEach var="item" items="${details}">
		<h1>${item.movieName}</h1>

		<img src="../Images?id=${item.movieID}">
		<br>

	Description: <div>${item.description}</div><br>
	Rating: <div>${item.rating}</div><br>
	Theatre Name: <div>${item.theatreName}</div><br>
	Showroom: <div>${item.showroomID}</div><br>
	Showtime: <div>${item.startTime}</div><br>
	Price per seat: <div>${item.price}</div><br>
	Available Seats: <div>${item.availableSeats}</div><br>
	<br>
	<form action=../UpdateCartServlet name="userForm" method="get" >
			Number of Tickets: 		<select name=tickets>
								<c:forEach var="i" begin="0" end="${item.availableSeats}">
									<option><c:out value="${i}"></c:out> </option>							
								</c:forEach>						
							</select>
			<input hidden=true type=text name=remove value="false">				
			<input hidden=true type=number name=id value=<%=session.getAttribute("userID")%>>
			<input hidden=true type=text name=movie value=${item.movieName}>
			<input hidden=true type=number name=movieID value=${item.movieID}>
			<input hidden=true type=number name=price value=${item.price}>			
			<input hidden=true type=text name=theatre value=${item.theatreName}>
			<input hidden=true type=text name=startTime value=${item.startTime}>
			<input hidden=true type=text name=image value=${item.image}>
			<input hidden=true type=number name=showroomID value=${item.showroomID}>
					
			<input type=submit value=Add> <br> 
	</form>
	</c:forEach>
	<br>
	<h2>Viewer Reviews</h2>
	<br>
	<h3>Add a Review</h3>
		<form action=../CustomerReviewServlet name="userForm" method="get" >
			
			<c:forEach var="item" items="${details}">
			<input hidden=true type=text name=movie value=${item.movieName}>
			<input hidden=true type=number name=movieID value=${item.movieID}>						
			</c:forEach>								
			<input hidden=true type=number name=id value=<%=session.getAttribute("userID")%>>
			<input type=submit value=Add> <br> 
		</form>
	
	<c:forEach var="item" items="${reviews}">
	<h3>${item.userName}</h3>
	Rating: <div>${item.rating}</div><br>
	Description: <div>${item.description}</div><br>	
	Date: <div>${item.date}</div><br>
	</c:forEach>
	
	<br>
	<br>
	<br>
	<input type="button" onclick="location.href='CustomerReview.jsp';"
		value="Add Review" />
	<br>
	<br>


	<!-- Navigation links -->
	<a href="CustomerHomePage.jsp"> Home Page </a>
	<br>
	<a href="../Register.jsp"> New User </a>
	<br>
	<a href="../Welcome.jsp"> Log Out </a>
	<br>
</body>
</html>