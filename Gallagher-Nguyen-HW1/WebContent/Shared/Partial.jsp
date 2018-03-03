<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Users" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body onload="showPartial()">
<% Users user = new Users(); %>
<script>
function showPartial(){
	Users usr = new Users();
	if(usr.getLog()){
		document.getElementById("partial").style.display = "initial";
	}else{
		document.getElementById("partial").style.display = "none";
	}	
}
	
</script>

<div class="navbar navbar-inverse navbar-fixed-top" id="partial">
        <div class="container">
            <div class="navbar-header">
                <a href="CustomerHomePage.jsp" class="navbar-brand" >Tickets Plus</a>                
            </div>
            <div class="navbar-collapse collapse" id="MainMenu"  style="height: 1px;">
              
                <ul class="nav navbar-nav">    
                	                                
                </ul>
                <ul class="nav navbar-nav navbar-right">                    
                    <li class="collapse-hidden">
                        <ul class="nav navbar-nav navbar-right">
                        	<li><a class="navbar-right">Welcome <%=session.getAttribute("userName")%></a></li>                        
                        	<li> <a href="ViewOrders.jsp"> View Orders </a> </li>
                            <li> <a href="../Welcome.jsp"> Log Out </a></li>                               
                        </ul>
                    </li>
                </ul>
            </div>
          </div>
    </div>
<br>
<br>
</body>
</html>