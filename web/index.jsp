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
            <div class ="header">
                <div class="headerImg">
                    <img src="css/customer.jpg" height="200px" />
                </div>
                <div class="headerText">
                <%@ include file="includes/header.jsp" %>
                </div>
            <%@ include file="includes/main.jsp" %>
            
            <div class="main">
            <h1>Customers Database</h1>
            <a href="read2">View All Customers</a>
            <br><br>
            </div>
		
                    
	     
		
            <%@ include file="includes/footer.jsp" %>    
	</div>
        </div>
        
    </body>
</html>
