<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <<jsp:include page="CustomerHomePage.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<h1>Search Results</h1> <br> <br>

<table border="1">
	<thead>
		<tr>
			<th>Movie Name</th>
			<th>Theater Showing</th>
			<th>Theater Number</th>
			<th>Showtime</th>
			<th>Available Seats</th>
			<th>Price</th>
			<th>Image</th>
			<th>View Details</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Star Wars: The Last Jedi</td>
			<td>Marcus Lincoln Grand Cinema</td>
			<td>12</td>
			<td>7:30pm</td>
			<td>20</td>
			<td>$10</td>
			<td><img src="lastjedithumbnail.jpg" /></td>
			<td><input type="button" onclick="location.href='MovieDetailsSelection.jsp';" value="View Details"/></td>
		</tr>
	</tbody>
</table>

<br>
<!-- Navigation links --> 

<a href="CustomerHomePage.jsp"> Home Page </a> <br>
<a href="../Register.jsp"> New User </a> <br>
<a href="../Welcome.jsp"> Log Out </a> <br>
</body>
</html>