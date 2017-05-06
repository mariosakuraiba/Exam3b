
<%@page import="model.Customers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Customers customer = (Customers) request.getAttribute("customer"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <title>Update Records</title>
    </head>
    <body>
        <h1>Update Existing Records</h1>
        
        <form name="updateForm" action="updateCustomer" method="get">
            <table class="update">  
                <tr>
                    <td class="right">Customer ID:</td>
                    <td><input type="text" name="custID" value="<%= customer.getCustID() %>" readonly/></td>
                </tr>
            
            <tr>
            <td><label>First Name:</label></td>
            <td><input type="text" name="firstName" size="50" value="<%= customer.getFirstName() %>"/></td>
            </tr><br>
            <tr>
            <td><label>Last Name:</label></td>
            <td><input type="text" name="lastName" size="50" value="<%= customer.getLastName() %>"/></td>
            </tr><br>
            <tr>
            <td><label>Address1:</label></td>
            <td><input type="text" name="custAddr1" size="50" value="<%= customer.getCustAddr1() %>"/></td>
            </tr><br>
            <td><label>Address2:</label></td>
            <td><input type="text" name="custAddr2" size="50" value="<%= customer.getCustAddr2() %>"/></td>
            </tr><br>
            <td><label>City:</label></td>
            <td><input type="text" name="custCity" size="50" value="<%= customer.getCustCity() %>"/></td>
            </tr><br>
            <td><label>State:</label></td>
            <td><input type="text" name="custState" size="50" value="<%= customer.getCustState() %>"/></td>
            </tr><br>
            <td><label>Zip:</label></td>
            <td><input type="text" name="custZip" size="50" value="<%= customer.getCustZip() %>"/></td>
            </tr><br>
            <td><label>Email:</label></td>
            <td><input type="text" name="emailAddr" size="50" value="<%= customer.getEmailAddr() %>"/></td>
            </tr><br>
            
                <td><input type="reset" name="reset" value="Clear" /></td>
                <td><input type="submit" name="submit" value="Update" /></td>
              
            </table>
        </form>     
    </body>
</html>
