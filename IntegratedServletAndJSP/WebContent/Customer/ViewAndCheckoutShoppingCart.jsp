<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Checkout</title>
</head>
<body>
<h1>Checkout Page</h1>
<table border="1">
	<thead>
		<tr>
			<th>Movie Name</th>
			<th>Image</th>
			<th>Theater Name</th>
			<th>Theater Number</th>
			<th>Showtime</th>
			<th>Date</th>
			<th># of tickets</th>
			<th>Total Price</th>
			<th>Remove item</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Star Wars: The Last Jedi</td>
			<td><img src="lastjedithumbnail.jpg" /></td>
			<td>Marcus Lincoln Grand Theater</td>
			<td>12</td>
			<td>7:30pm</td>
			<td>1/31/2018</td>
			<td>1</td>
			<td>$10.00</td>
			<td><input type="button"  value="Remove"/></td>
		</tr>
	</tbody>
</table>
<br>
Total Cost: $10.00 <br>
<input type="button" onclick="location.href='CustomerTransaction.jsp';" value="Checkout"/> <br>
<br>
<!-- Navigation links --> 
<a href="CustomerHomePage.jsp"> Home Page </a> <br>
<a href="Register.jsp"> New User </a> <br>
<a href="Welcome.jsp"> Log Out </a> <br>
</body>
</html>