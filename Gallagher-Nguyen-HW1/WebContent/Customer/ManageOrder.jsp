<jsp:include page="../Shared/Partial.jsp"></jsp:include>

<title>Manage Order</title>

</head>
<body>
<h1>Manage Order</h1> <br> <br>
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
	<tbody>
		<tr>
			<td>${movie.title}</td>
			<td>${theatre}</td>
			<td>${orderItems.count}</td>
			<td>${order.cost}</td>
			<td>${order.orderDate}</td>
			<td>${movieShowing.startTime}</td>
			<td>
			
			<form action=../CancelOrderServlet name="userForm" method="get">
								<input hidden=true type=number name=orderid value=${order.orderID}>
			<input type=submit value="Cancel">
			</form>
		</tr>
	</tbody>
</table>




</body>
</html>