<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Cancel Confirmation</title>

</head>
<body>
<h1>Cancel Confirmation</h1> <br> <br>
<c:forEach var="item" items="${theOrder}">
<h3> Order Number: ${item.orderID} </h3>
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
			<th>Order Status</th>
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
			<td> Cancelled</td>	
		</tr>
	</tbody>
	</c:forEach>
</table>

<div align="right">
<c:forEach var="item" items="${theOrder}">
	Refund Total: ${item.total} <br>
	</c:forEach>
	Refund Date: <p id="date"></p> <br>
	<a href="CustomerHomePage.jsp"> Cancel Order </a> <br>
</div>
</body>
<script>
document.getElementById("date").innerHTML = Date();
</script>
</html>