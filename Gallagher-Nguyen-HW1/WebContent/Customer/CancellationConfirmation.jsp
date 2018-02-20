<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Cancel Confirmation</title>
<a href="CustomerHomePage.jsp"> Home Page </a> <br>
<a href="../Welcome.jsp"> Log Out </a> <br>
<a href="ViewOrders.jsp"> View Orders </a> <br>
</head>
<body>
<h1>Cancel Confirmation</h1> <br> <br>
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
			<th>Status</th>
					
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
			<td>Pending Cancellation</td>
		</tr>
	</tbody>
</table>
</center>
<div align="right">
	Refund Total: $10.00 <br>
	Refund Date: <%= (new java.util.Date()).toLocaleString()%> <br>
	<a href="CustomerHomePage.jsp"> Cancel Order </a> <br>
</div>
</body>
</html>