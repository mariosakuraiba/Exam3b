<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Customers</title>
    </head>
    <body>
        <% String table2 = (String) request.getAttribute("table2");%>
        <h1>Customers Table</h1>
        
        <div class="wrap"> 
            
        <%@ include file="includes/header.jsp" %>
        
        <hr>
        <%@ include file="includes/main.jsp" %>
        <hr>
        
        <div class="main"> 
            
        <h2>Search Customers</h2>
        <div align="center">
        <form name="searchForm2" action="search2" method="get">
            
            <input type="text" name="searchVal2" value=""/>
            
            <br>
            
            <input type="submit" name="submit" value="Search"/>
        </form>
        </div>
        
         </div> 
        </div>
        <hr>
        
    </body>
</html>