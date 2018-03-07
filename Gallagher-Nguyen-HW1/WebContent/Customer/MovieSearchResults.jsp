<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Search Results</title>
</head>
<body>
	<h1>Search Results</h1>
	<br>
	<br>

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

					<td>${item.movieName}</td>
					<td>${item.theatreName}</td>
					<td>${item.theatreNumber}</td>
					<td>${item.startTime}</td>
					<td>${item.availableSeats}</td>
					<td>${item.price}</td>
					<td><img src=${item.image}></td>
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