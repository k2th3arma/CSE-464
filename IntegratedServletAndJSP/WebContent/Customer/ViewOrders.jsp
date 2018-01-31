<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Orders</title>
</head>
<a href="CustomerHomePage.jsp"> Home </a> <br>
<a href="../Welcome.jsp"> Log out</a> <br>
<body>
<table>
<tr>
<th>Order Number</th>
<th>Order Total</th>
<th>Ordered Date</th>
<th>Manage Order</th>
</tr>

<tr>
<td>654</td>
<td>$42.00</td>
<td>1/18/18</td>
<td><a href="ManageOrder.jsp">Manage</a>
</tr>
</table>
	
</body>



<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        align-self:auto;
    }

    th, td {
        padding: 5px;
    }
</style>
</html>