
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <title>Customers Table</title>
    </head>
    <% String table2 = (String) request.getAttribute("table2");%>
    <body>
        <h1>Customers Table</h1>
        <%= table2 %>
        <br><br>
        
        <form name="searchForm2" action="search2" method="get">
        <b> Search for customers by entering first or last name. </b>
        <br><br>
        <input id="text" type="text" name="searchVal2" value="" />
        <input id="button" type="submit" name="submit" value="Go"/></form><br><br>
        <a href="index.jsp">Return to the previous page</a>
    </body>
</html>
