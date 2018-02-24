<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

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