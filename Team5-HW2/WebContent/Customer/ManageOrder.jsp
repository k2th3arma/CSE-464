<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Manage Order</title>

</head>
<body>
<h1>Manage Order</h1> <br> <br>
<c:forEach var="item" items="${theOrder}">
<h3> Order Number: ${item.orderID}</h3>
</c:forEach>
<table border="1">
	<thead>
		<tr>
			<th>Movie Name</th>
			<th>Theater Name</th>
			<th># of tickets</th>
			<th>Total Price</th>
			<th>Purchase Date</th>
			<th>Show Time</th>
			<th>Cancel Order</th>
		</tr>
	</thead>
	<c:forEach var="item" items="${theOrder}">
	<tbody>
		<tr>
		
			<td><c:out value="${item.movieName}"/></td>
			<td><c:out value="${item.theatreName}"/></td>
			<td><c:out value="${item.tickets}"/></td>
			<td><c:out value="${item.total}"/></td>
			<td><c:out value="${item.date}"/></td>
			<td><c:out value="${item.startTime}"/></td>
			<td>
			
			<form action=../CancelOrderServlet name="userForm" method="get">
								<input hidden=true type=number name=orderID value=${item.orderID}>
			<input type=submit value="Cancel">
			</form>
		</tr>
	</tbody>
	</c:forEach>
</table>




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