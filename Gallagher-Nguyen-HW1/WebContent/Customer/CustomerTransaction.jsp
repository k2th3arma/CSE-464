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
					<td>${item.price} * ${item.tickets}</td>
					<td>
					<br>
									
					</td>
		</tr>
	</tbody>
	</c:forEach>
</table>
<br>
Total Cost: ${total} <br>
<br>
<h2>Payment Info</h2>

	Account Holder First Name:
	<input type="text" name="firstName"><br>
	
	Account Holder Last Name:
	<input type="text" name="lastName"><br>
	
	Card Type:
	<select name="cardType">
		<option value ="Visa">Visa</option>
		<option>Mastercard</option>
		<option>Discover</option>
	</select><br>
	
	Card Number:
	<input type="text" name="cardNumber"><br>
	
	Security Code:
	<input type="text" name="securityCode"><br>
	
	Expiration Date:
	<select name="expMonth">
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
	<select name="expDay">
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
		<option>13</option>
		<option>14</option>
		<option>15</option>
		<option>16</option>
		<option>17</option>
		<option>18</option>
		<option>19</option>
		<option>20</option>
		<option>21</option>
		<option>22</option>
		<option>23</option>
		<option>24</option>
		<option>25</option>
		<option>26</option>
		<option>27</option>
		<option>28</option>
		<option>29</option>
		<option>30</option>
		<option>31</option>
	</select><br>
	
	Billing Address:
	<input type="text" name="billingAddress"><br>
	
	Shipping Address:
	<input type="text" name="shippingAddress"><br>
	
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