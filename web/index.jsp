<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers Table</title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        
        <div class = "wrap">
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/main.jsp" %>
            <div class="main">
            <h1>Customers Database</h1>
            <a href="read">View All Customers</a>
            <br><br>
            <a href="search.jsp">Search Customers</a>
            </div>
		
                    
		
		
            <%@ include file="includes/footer.jsp" %>    
	</div>
        
    </body>
</html>
