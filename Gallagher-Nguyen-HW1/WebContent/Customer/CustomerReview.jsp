<jsp:include page="../Shared/Partial.jsp"></jsp:include>

<title>Customer Review Page</title>
<html>
<body>

<h1> Customer Review</h1>

What did you think of the movie?: <br>
<textarea name="reviewText" cols="40" rows="5"></textarea><br>
Star Rating: <br>
<select name="starRating">
		<option>5 (Masterpiece)</option>
		<option>4 (Great)</option>
		<option>3 (Fine)</option>
		<option>2 (Bad)</option>
		<option>1 (Awful)</option>
	</select>

<br>

<input type="button" onclick="location.href='CustomerReviewConfirmation.jsp';" value="Submit Review"/> <br>
<input type="button" onclick="location.href='MovieDetailsSelection.jsp';" value="Cancel"/> <br>

</body>
</html>