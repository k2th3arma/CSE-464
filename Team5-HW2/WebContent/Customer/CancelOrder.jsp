<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Cancel Order</title>

</head>
<body>
<h1>Cancel Order</h1> <br> <br>

<h3> Order Number: ${order.orderID}</h3>

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
		
			<td>${item.movieName}</td>
			<td>${item.theatreName}</td>
			<td>${item.tickets}</td>
			<td>${item.total}</td>
			<td>${item.date}</td>
			<td>${item.startTime}</td>
			<td>
			<form action=../CancelTransactionServlet name="userForm" method="get">
								<input hidden=true type=number name=orderID value=${item.orderID}>
			<input type=submit value="Confirm">
			</form>
			
		</tr>
	</tbody>
	</c:forEach>
</table>

<div align="right">	
	<a href="CustomerHomePage.jsp">Discard Cancel</a>
</div>
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