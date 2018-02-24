<jsp:include page="../Shared/Partial.jsp"></jsp:include>

<title>Manage Order</title>

</head>
<body>
<h1>Manage Order</h1> <br> <br>
<h3> Order Number: 001</h3>
<center>
<table border="1">
	<thead>
		<tr>
			<th>Movie Name</th>
			<th>Theater Name</th>
			<th># of tickets</th>
			<th>Total Price</th>
			<th>Date</th>
			<th>Show Time</th>
					
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><a href="MovieDetailsSelection.jsp">Star Wars: The Last Jedi</a></td>
			<td>Marcus Lincoln Grand Theater</td>
			<td>1</td>
			<td>$10.00</td>
			<td>1/20/18</td>
			<td>17:30</td>
		</tr>
	</tbody>
</table>
</center>
<div align="right">
	Order Total: $10.00 <br>
	Order Date: 1/18/18 <br>
	<a href="CancelOrder.jsp"> Cancel Order </a> <br>
</div>



</body>
</html>