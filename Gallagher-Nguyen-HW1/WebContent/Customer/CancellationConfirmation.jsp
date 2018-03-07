<jsp:include page="../Shared/Partial.jsp"></jsp:include>

<title>Cancel Confirmation</title>

</head>
<body>
<h1>Cancel Confirmation</h1> <br> <br>
<h3> Order Number: 001</h3>

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
	<tbody>
		<tr>
			<td>${movie.title}</td>
			<td>${theatre}</td>
			<td>${orderItems.count}</td>
			<td>${order.cost}</td>
			<td>${order.orderDate}</td>
			<td>${movieShowing.startTime}</td>
			<td> Cancelled</td>	
		</tr>
	</tbody>
</table>

<div align="right">
	Refund Total: $${order.cost} <br>
	Refund Date: <%= (new java.util.Date()).toLocaleString()%> <br>
	<a href="CustomerHomePage.jsp"> Cancel Order </a> <br>
</div>
</body>
</html>