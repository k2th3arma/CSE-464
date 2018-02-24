<jsp:include page="../Shared/Partial.jsp"></jsp:include>

<title>Cancel Order</title>

</head>
<body>
<h1>Cancel Order</h1> <br> <br>
<h3> Order Number: 001</h3>

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

<div align="right">	
	<a href="CancellationConfirmation.jsp"> Cancel Order </a> <br>
	<a href="CustomerHomePage.jsp">Discard Cancel</a>
</div>
</body>
</html>