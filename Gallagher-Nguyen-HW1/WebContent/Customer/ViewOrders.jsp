<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>View Orders</title>

<body>
	<h1>View Orders</h1> <br> <br>
	
<table border="1">
	<thead>
		<tr>
			<th>Order Number</th>
			<th>Order Total</th>
			<th>Ordered Date</th>
			<th>Manage Order</th>
		</tr>
	</thead>
	<c:forEach var="item" items="${orders}">
	<tbody>
		<tr>
					<td>${item.orderID}</td>
					<td>$${item.cost}</td>
					<td>${item.orderDate}</td>
					<td>
					
					<form action=../ManageOrdersServlet name="userForm" method="get">
								<input hidden=true type=number name=orderid value=${item.orderID}>
								<input type=submit value="View"> 

					</form>
					
					</td>
					<td>
					<br>
									
					</td>
		</tr>
	</tbody>
	</c:forEach>
</table>
	
</body>


</html>