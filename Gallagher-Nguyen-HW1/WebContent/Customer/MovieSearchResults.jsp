<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Search Results</title>
</head>
<body>
<h1>Search Results</h1> <br> <br>

<table border="1">
<thead>
	<tr>
		<th>Movie Name</th>
		<th>Theater Showing</th>
		<th>Theater Number</th>
		<th>Showtime</th>
		<th>Available Seats</th>
		<th>Price</th>
		<th>Image</th>
		<th>View Details</th>
	</tr>
</thead>
<tbody>
	<tr>
		<td><c:out value="${Movies.title}"/></td>
		<td><c:out value="${MoviesShowing.showroom}"/></td>
		<td>12</td>
		<td><c:out value="${MoviesShowing.startTime}"/></td>
		<td><c:out value="${MoviesShowing.seatCount}"/></td>
		<td><c:out value="${MoviesShowing.price}"/></td>
		<td><img src="lastjedithumbnail.jpg" /></td>
		<td><input type="button" onclick="location.href='MovieDetailsSelection.jsp';" value="View Details"/></td>
	</tr>
</tbody>
</table>

<!--<c:out value="${Movies})"/><br>-->
<c:out value="${MoviesShowing}"/><br>

<br>
<!-- Navigation links --> 

<a href="CustomerHomePage.jsp"> Home Page </a> <br>
<a href="../Register.jsp"> New User </a> <br>
<a href="../Welcome.jsp"> Log Out </a> <br>
</body>
</html>