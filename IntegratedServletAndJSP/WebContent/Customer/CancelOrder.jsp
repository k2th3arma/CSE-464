<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Order</title>
<a href="../Welcome.jsp"> Log Out </a> <br>
<a href="ViewOrders.jsp"> View Orders </a> <br>
</head>
<body>
<h1>Cancel Order</h1> <br> <br>
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
	<a href="CancellationConfirmation.jsp"> Cancel Order </a> <br>
	<a href="CustomerHomePage.jsp">Discard Cancel</a>
</div>
</body>
</html>