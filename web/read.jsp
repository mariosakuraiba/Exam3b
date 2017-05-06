
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <title>Customers Table</title>
    </head>
    <% String table = (String) request.getAttribute("table");%>
    <body>
        <h1>Customers Table</h1>
        <%= table %>
        <br><br>
        <a href="add">Add A New Course</a><br><br>
        <a href ="search.jsp">Search Courses</a><br><br>
        <a href="index.jsp">Return to the previous page</a>
    </body>
</html>
