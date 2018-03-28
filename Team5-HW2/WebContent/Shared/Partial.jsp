<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Users"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		</script>

<script type=text/javascript>

document.ready(function(){	
	alert("Partial : "<%=session.getAttribute("userType")%>);
	
	if(<%=session.getAttribute("userType")%>.equals("owner")){
		document.getElementById("owner").style.display = "initial";
		document.getElementById("customer").style.display = "none";
	}else{
		document.getElementById("owner").style.display = "none";
		document.getElementById("customer").style.display = "initial";
	}
});
	
</script>

</head>

<body>




	<div id="customer">
		<div class="navbar navbar-inverse navbar-fixed-top" id="partial">
			<div class="container">
				<div class="navbar-header">
					<a href="CustomerHomePage.jsp" class="navbar-brand">Tickets
						Plus</a>
				</div>
				<div class="navbar-collapse collapse" id="MainMenu"
					style="height: 1px;">

					<ul class="nav navbar-nav">

					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="collapse-hidden">
							<ul class="nav navbar-nav navbar-right">
								<li><a class="navbar-right">Welcome <%=session.getAttribute("userName")%></a></li>
								<li><a href="../Customer/ViewAndCheckoutShoppingCart.jsp"> Shopping Cart</a>
								<li><a href="../ViewOrdersServlet"> View Orders </a></li>
								<li><a href="../Logout"> Log Out </a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>
</body>
</html>