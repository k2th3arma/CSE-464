<jsp:include page="../Shared/Partial.jsp"></jsp:include>

<title>Customer Review Confirmation</title>
<html>
<body>

<%
	String message = "";
	if(session.getAttribute("problem").equals(1)){
		message = "There was a problem with your submission.";
	}
	else{
		message = "Review Submission Successful!";
	}
%>

<h1><%=message%></h1>

</body>
</html>