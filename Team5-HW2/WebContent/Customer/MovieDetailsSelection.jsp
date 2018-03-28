<jsp:include page="../Shared/Partial.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<title>Movie Details</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		</script>

<script>
			function getdata() {			
				
				var tickets = $("#tickets").val();
				var remove  = $("#remove").val();
				var id  = $("#id").val();
				var movie  = $("#movie").val();
				var movieID  = $("#movieID").val();
				var price  = $("#price").val();
				var theatre  = $("#theatre").val();
				var startTime  = $("#startTime").val();
				var image  = $("#image").val();
				var showroomID  = $("#showroomID").val();
			
			    // Sending request to another app named "FormjQueryResponse"
			    // Before sending request, run the app "FormjQueryResponse" on server first
			    //$.post("../FormjQueryResponse/FormjQueryResponse", {fName:firstName, lName:lastName}, function(data,status) {
			    
			    	// Sending request to servlet of the same app
			    $.get("../UpdateCartServlet", {tickets:tickets, remove:remove, id:id, movie:movie, movieID:movieID, price:price, theatre:theatre, startTime:startTime, showroomID:showroomID, image:image}, function(data,status) {
			    	    	
			    			//Insert the result in your page
						$("#results").html(data);
					});
			   alert("Added to Cart");
	
			  }
			    
			  function addReview(){
				  var rating = $("#rating").val();
				  var description = $("#description").val();
				  var movieID = $("#movieID").val();
				  var date = $("#date").val();
				  var id = $("#id").val();
				  
				  $.post("../CustomerReviewServlet", {rating:rating, description:description, movieID:movieID, date:date, id:id}, function(data,status) {
		    	    	
		    			//Insert the result in your page
					$("#results").html(data);
				});
		  		location.reload();
		   
			  }
		</script>
		
</head>

<body>
	
	<br>
	
	
	<c:forEach var="item" items="${details}">
		<h1>${item.movieName}</h1>

		<img src="../Images?id=${item.movieID}">
		<br>

	Description: <div>${item.description}</div><br>
	Rating: <div>${item.rating}</div><br>
	Theatre Name: <div>${item.theatreName}</div><br>
	Showroom: <div>${item.showroomID}</div><br>
	Showtime: <div>${item.startTime}</div><br>
	Price per seat: <div>${item.price}</div><br>
	Available Seats: <div>${item.availableSeats}</div><br>
	<br>
	<!--  <form action=../UpdateCartServlet name="userForm" method="get" > -->
			Number of Tickets: 		<select id=tickets>
								<c:forEach var="i" begin="0" end="${item.availableSeats}">
									<option><c:out value="${i}"></c:out> </option>							
								</c:forEach>						
							</select>
			<input hidden=true type=text id=remove value="false">				
			<input hidden=true type=number id=id value=<%=session.getAttribute("userID")%>>
			<input hidden=true type=text id=movie value=${item.movieName}>
			<input hidden=true type=number id=movieID value=${item.movieID}>
			<input hidden=true type=number id=price value=${item.price}>			
			<input hidden=true type=text id=theatre value=${item.theatreName}>
			<input hidden=true type=text id=startTime value=${item.startTime}>
			<input hidden=true type=text id=image value=${item.image}>
			<input hidden=true type=number id=showroomID value=${item.showroomID}>
					
			<input type=submit value=Add onClick="getdata()"> <br> 
	
	</c:forEach>
	<br>
	<h2>Viewer Reviews</h2>
	<br>
	<h3>Add a Review</h3>
		<form action=../CustomerReviewServlet name="userForm" method="get" >
			
			<c:forEach var="item" items="${details}">
			<input hidden=true type=text name=movie value=${item.movieName}>
			<input hidden=true type=number name=movieID value=${item.movieID}>						
			</c:forEach>								
			<input hidden=true type=number name=id value=<%=session.getAttribute("userID")%>>
			<input type=submit value=Add> <br> 
		</form>
	
	<c:forEach var="item" items="${reviews}">
	<h3>${item.userName}</h3>
	Rating: <div>${item.rating}</div><br>
	Description: <div>${item.description}</div><br>	
	Date: <div>${item.date}</div><br>
	</c:forEach>
	
	<br>
	<br>
	<br>
	<input type="button" onclick="location.href='CustomerReview.jsp';"
		value="Add Review" />
	<br>
	<br>
	<h1> Customer Review</h1>

What did you think of the movie?: <br>


			
			
			
	Star Rating: <br>
<select id="rating">
		<option>5 </option>
		<option>4 </option>
		<option>3 </option>
		<option>2 </option>
		<option>1 </option>
	</select>		
	Description: <input type="text" id=description>	<br>	
			
			<c:forEach var="item" items="${reviews}">
			<input hidden=true type=number id=movieID value=${item.movieID}>	
			<input hidden=true type=text id=date value=${item.date}>					
			</c:forEach>								
			<input hidden=true type=number id=id value=<%=session.getAttribute("userID")%>>
			
			<input type=submit value=Add onClick="addReview()"> <br> 
		

<br>

	<!-- Navigation links -->
	<a href="CustomerHomePage.jsp"> Home Page </a>
	<br>
	<a href="../Register.jsp"> New User </a>
	<br>
	<a href="../Welcome.jsp"> Log Out </a>
	<br>
</body>
</html>