<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Search Results</title>
</head>
<body>
	<h1>Search Results</h1>
	<br>
	<br>
<img hidden="ture" src="../Images?id=1">
	<table>
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
		<c:forEach var="item" items="${movies}">
			<tbody>
				<tr>
					
					<td><c:out value="${item.movieName}"/></td>
					<td><c:out value="${item.theatreName}"/></td>
					<td><c:out value="${item.theatreNumber}"/></td>
					<td><c:out value="${item.startTime}"/></td>
					<td><c:out value="${item.availableSeats}"/></td>
					<td><c:out value="${item.price}"/></td>
					<td><img src="../Images?id=${item.movieID}"></td>
					<td>
						<form action=../MovieDetailsServlet name="userForm" method="get">
								<input hidden=true type=number name=id value=${item.movieID}>
								<input hidden=true type=text name=theatre value=${item.theatreName}>
							<input type=submit value="Details"> <br>

						</form>

					</td>


				</tr>
			</tbody>
		</c:forEach>
	</table>


	<!--<c:out value="${Movies})"/><br>-->
	<c:out value="${MoviesShowing}" />
	<br>

	<br>

	<br>
</body>
</html>

<style>
table,th,td {
	border: 1px solid black;
	margin: 0px auto
}

th,td {
	padding: 10px;
}
</style>