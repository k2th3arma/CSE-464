<jsp:include page="../Shared/Partial.jsp"></jsp:include>

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
	<tbody>
		<tr>
			<td>${movie.title}</td>
			<td>${theatre}</td>
			<td>${orderItems.count}</td>
			<td>${order.cost}</td>
			<td>${order.orderDate}</td>
			<td>${movieShowing.startTime}</td>
			<td>
			
			<form action=../CancelTransactionServlet name="userForm" method="get">
								<input hidden=true type=number name=orderid value=${order.orderID}>
			<input type=submit value="Confirm">
			
		</tr>
	</tbody>
</table>

<div align="right">	
	<a href="CustomerHomePage.jsp">Discard Cancel</a>
</div>
</body>
</html>