<%@page import="com.sun.xml.internal.txw2.Document"%>
<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

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
			<th>Showtime</th>
			<th># of tickets</th>
			<th>Total Price</th>
			<th>Remove item</th>
		</tr>
	</thead>
	<c:forEach var="item" items="${Shoppingcart}">
	<tbody>
		<tr>

			<td>${item.movieName}</td>
			<td><img src=${item.image}></td>
					<td>${item.theatreName}</td>
					<td>${item.startTime}</td>
					<td>${item.tickets}</td>
					<td>${item.price} * ${item.tickets}</td>
					<td>
					<form action=../UpdateCartServlet name="userForm" method="get">
					<input hidden=true type=text name=tickets value=${item.tickets}>	
								<input hidden=true type=text name=remove value="false">				
			<input hidden=true type=number name=id value=<%=session.getAttribute("userID")%>>
			<input hidden=true type=text name=movie value=${item.movieName}>
			<input hidden=true type=number name=movieID value=${item.movieID}>
			<input hidden=true type=number name=price value=${item.price}>			
			<input hidden=true type=text name=theatre value=${item.theatreName}>
			<input hidden=true type=text name=startTime value=${item.startTime}>
			<input hidden=true type=text name=image value=${item.image}>
								
							<input type=submit value="Cancel"> <br>

						</form>
					
					
					</td>
		</tr>
	</tbody>
	</c:forEach>
</table>
<br>
Total Cost: $${total} <br>
<input type="button" onclick="location.href='CustomerTransaction.jsp';" value="Checkout"/> <br>
<br>
<!-- Navigation links --> 
<a href="CustomerHomePage.jsp"> Home Page </a> <br>
<a href="../Register.jsp"> New User </a> <br>
<a href="../Welcome.jsp"> Log Out </a> <br>
</body>
</html>