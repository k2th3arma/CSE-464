<jsp:include page="../Shared/Partial.jsp"></jsp:include>

<title>Customer Transaction</title>
</head>
<body>
<h1>Transaction Page</h1>
<table border="1">
	<thead>
		<tr>
			<th>Movie Name</th>
			<th>Theater Name</th>
			<th># of tickets</th>
			<th>Total Price</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Star Wars: The Last Jedi</td>
			<td>Marcus Lincoln Grand Theater</td>
			<td>1</td>
			<td>$10.00</td>
		</tr>
	</tbody>
</table>
<br>
Total Cost: $10.00 <br>
<br>
<h2>Payment Info</h2>
	Account Holder First Name:
	<input type="text" name="firstName"><br>
	
	Account Holder Last Name:
	<input type="text" name="lastName"><br>
	
	Card Type:
	<select name="country">
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
		<option>01</option>
		<option>02</option>
		<option>03</option>
		<option>04</option>
		<option>05</option>
		<option>06</option>
		<option>07</option>
		<option>08</option>
		<option>09</option>
		<option>10</option>
		<option>11</option>
		<option>12</option>
	</select>/
	<select name="expDay">
		<option>01</option>
		<option>02</option>
		<option>03</option>
		<option>04</option>
		<option>05</option>
		<option>06</option>
		<option>07</option>
		<option>08</option>
		<option>09</option>
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
	

<input type="button" onclick="location.href='CustomerTransactionConfirmation.jsp';" value="Confirm Payment"/> <br>
<input type="button" onclick="location.href='ViewAndCheckoutShoppingCart.jsp';" value="Cancel Payment"/> <br>
<input type="button" onclick="location.href='ViewOrders.jsp';" value="View Orders"/> <br>
<br>
<!-- Navigation links --> 
<a href="CustomerHomePage.jsp"> Home Page </a> <br>
<a href="../Register.jsp"> New User </a> <br>
<a href="../Welcome.jsp"> Log Out </a> <br>
</body>
</html>