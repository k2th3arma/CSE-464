<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Transaction Confirmation</title>
</head>
<body>
<h1>Your order has been placed!</h1>
<table border="1">
	<thead>
		<tr>
			<th>Movie Name</th>
			<th>Theater Name</th>
			<th># of tickets</th>
			<th>Total Price</th>
		</tr>
	</thead>
	<c:forEach var="item" items="${Shoppingcart}">
	<tbody>
		<tr>
					<td><c:out value="${item.movieName}"/></td>
					<td><c:out value="${item.theatreName}"/></td>
					<td><c:out value="${item.tickets}"/></td>
					<td><c:out value="${item.total}"/></td>

		</tr>
	</tbody>
	</c:forEach>
</table>

<p>Name: <c:out value="${transaction.cardHolderName}"/></p>
<p>Card Type: <c:out value="${transaction.cardType}"/></p>
<p>Card Number: <c:out value="${transaction.cardNumber}"/></p>
<p>Card Security Code: <c:out value="${transaction.CVV}"/></p>
<p>Card Expiration: <c:out value="${transaction.expiration}"/></p>
<p>Billing Address: <c:out value="${order.address}"/></p>
<p>Date Ordered: <c:out value="${order.orderDate}"/></p>

<br>
Total Cost: ${total} <br>
<br>

<form action=../ViewOrdersServlet method="get">
							<input type=submit value="View Orders"> <br>
							</form>
<br>
<!-- Navigation links --> 
<a href="CustomerHomePage.jsp"> Home Page </a> <br>
<a href="../Register.jsp"> New User </a> <br>
<a href="../Welcome.jsp"> Log Out </a> <br>
</body>
</html>

<style>
table,th,td {
	border: 1px solid black;
	margin: 0px auto
}

th,td {
	padding: 10px;
}
</style>