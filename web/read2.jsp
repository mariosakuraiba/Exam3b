<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers List</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    
    <% String table2 = (String) request.getAttribute("table2"); %>
    
    <body>
        <h1>Customers List</h1>
        <%= table2 %>
        <br><br>
        <a href="add">Add A New Customer</a><br>
        <form name="searchForm" action="search" method="get">
        <b> Search for customers by entering first or last name. </b>
        <br><br>
        <input id="text" type="text" name="searchVal" value="" />
        <input id="button" type="submit" name="submit" value="Go"/></form><br><br>
        <a href="index.jsp">Return to the previous page</a>
    </body>
</html>