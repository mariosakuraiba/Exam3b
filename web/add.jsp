
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Course</title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <h1>Add A New Course</h1>
        
        <form name="addForm" action="addCustomer" method="get">
            <table class="add">
            
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="" required data-validation-required-message="Please enter first name." /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="" required data-validation-required-message="Please enter last name." /></td>
                </tr>
                <tr>
                    <td>Address1</td>
                    <td><input type="text" name="custAddr1" value="" required data-validation-required-message="Please enter address." /></td>
                </tr>
                <tr>
                    <td>Address2</td>
                    <td><input type="text" name="custAddr2" value=""  /></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><input type="text" name="custCity" value="" required data-validation-required-message="Please enter city." /></td>
                </tr>
                <tr>
                    <td>State</td>
                    <td><input type="text" name="custState" value="" required data-validation-required-message="Please enter state." /></td>
                </tr>
                <tr>
                    <td>Zip Code</td>
                    <td><input type="text" name="custZip" value="" required data-validation-required-message="Please enter zip code."/></td>
                </tr>
                <tr>
                    <td>Email Address</td>
                    <td><input type="text" name="emailAddress" value="" required data-validation-required-message="Please enter email address."/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" name="submit" value="Add" /></td>
                    <td><input type="reset" name="reset" value="Clear" /></td>
                </tr>
        </table>
        </form>
    </body>
</html>
