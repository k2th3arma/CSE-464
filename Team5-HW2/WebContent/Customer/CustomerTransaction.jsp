<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Customer Transaction</title>
</head>
<body>
<h1>Transaction Page</h1>

<form action=../CustomerTransactionServlet name="transactionForm" method="get">
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
					<td>${item.movieName}</td>
					<td>${item.startTime}</td>
					<td>${item.tickets}</td>
					<td>${item.total}</td>
					
		</tr>
	</tbody>
	</c:forEach>
</table>
<br>
Total Cost: ${total} <br>
<br>
<h2>Payment Info</h2>
<c:forEach var="item" items="${userData}">
	Account Holder First Name:
	<input type="text" name="firstName" value=${item.firstName} ><br>
	
	Account Holder Last Name:
	<input type="text" name="lastName" value=${item.firstName}><br>
	
	Card Type:
	<select name="cardType" value=${item.cardType}>
		<option value ="Visa">Visa</option>
		<option>Mastercard</option>
		<option>Discover</option>
	</select><br>
	
	Card Number:
	<input type="text" name="cardNumber" value=${item.cardNumber}><br>
	
	Security Code:
	<input type="text" name="securityCode" value=${item.cvv}><br>
	
	Expiration Date:
	<select name="expMonth" value=${item.cvv}>
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
		<option>6</option>
		<option>7</option>
		<option>8</option>
		<option>9</option>
		<option>10</option>
		<option>11</option>
		<option>12</option>
	</select>
	<select name=expDay value=${item.year}>
								<c:forEach var="i" begin="2018" end="2040">
									<option><c:out value="${i}"></c:out> </option>							
								</c:forEach>						
							</select>
	
	
	Billing Address:
	<input type="text" name="billingAddress" value=${item.billing}><br>
	
	Shipping Address:
	<input type="text" name="shippingAddress" value=${item.shipping}><br>
	
	
	</c:forEach>
	<input hidden=true type=number name=userID value=<%=session.getAttribute("userID")%>>
	<c:forEach var="item" items="${Shoppingcart}">
	<input hidden=true type=number name=total value=${item.total}>
	<input hidden=true type=text name=tickets value=${item.tickets}>
	<input hidden=true type=number name=movieID value=${item.movieID}>
	<input hidden=true type=number name=showroomID value=${item.showroomID}>
	</c:forEach>
	
							<input type=submit value="Confirm payment"> <br>
</form>
 <br>
<input type="button" onclick="location.href='ViewAndCheckoutShoppingCart.jsp';" value="Cancel Payment"/> <br>
<input type="button" onclick="location.href='ViewOrders.jsp';" value="View Orders"/> <br>
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