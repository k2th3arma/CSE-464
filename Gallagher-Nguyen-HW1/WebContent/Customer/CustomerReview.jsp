<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Customer Review Page</title>
<html>
<body>

<h1> Customer Review</h1>

What did you think of the movie?: <br>

<form action=../CustomerReviewServlet name="userForm" method="post" >
			
			
			
	Star Rating: <br>
<select name="rating">
		<option>5 </option>
		<option>4 </option>
		<option>3 </option>
		<option>2 </option>
		<option>1 </option>
	</select>		
	Description: <input type="text" name=description>	<br>	
			
			<c:forEach var="item" items="${reviews}">
			<input hidden=true type=number name=movieID value=${item.movieID}>	
			<input hidden=true type=text name=date value=${item.date}>					
			</c:forEach>								
			<input hidden=true type=number name=id value=<%=session.getAttribute("userID")%>>
			<input type=submit value=Add> <br> 
		</form>

<br>
	<li><a href="MovieDetailsSelection.jsp">Cancel</a><li>

</body>
</html>