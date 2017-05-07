
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

public class ReadQuery2 {
    
        private Connection conn;
        private ResultSet results;
              
   public ReadQuery2(){
       
   Properties props = new Properties();
   InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery2.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   String driver = props.getProperty("driver.name");
   String url = props.getProperty("server.name");
   String username = props.getProperty("user.name");
   String passwd = props.getProperty("user.password");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadQuery2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url,username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(ReadQuery2.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
   
   public void doRead(){
        
        
            try {
                String query = "select * from customers ORDER BY custID ASC";
                
                PreparedStatement ps = conn.prepareStatement(query);
                this.results = ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(ReadQuery2.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
   
   
   public String getHTMLTable2(){
   
                
        String table2 = "";
   
   
        table2 += "<table class= 'tableformat'>";
   
   
 
  
        table2 += "<tr class='tablehead'>";
        table2 += "<th>Customer ID</th>";
        table2 += "<th>First Name</th>";
        table2 += "<th>Last Name</th>";
        table2 += "<th>Email</th>";

        table2 += "</tr>";

   
   
   
           
            try {
                while(this.results.next()){
                    
                    Customers customer = new Customers();
                    customer.setCustID(this.results.getInt("custID"));
                    customer.setFirstName(this.results.getString("firstName"));
                    customer.setLastName(this.results.getString("lastName"));
                    customer.setCustAddr1(this.results.getString("custAddr1"));
                    customer.setCustAddr2(this.results.getString("custAddr2"));
                    customer.setCustCity(this.results.getString("custCity"));
                    customer.setCustState(this.results.getString("custState"));
                    customer.setCustZip(this.results.getString("custZip"));
                    customer.setEmailAddr(this.results.getString("emailAddr"));
                    
                    
                    table2 += "<tr>";
                    table2 += "<td>";
                    table2 +=  customer.getCustID();
                    table2 += "</td>";
                    
                    table2 += "<td>";
                    table2 +=  customer.getFirstName();
                    table2 += "</td>";
                    
                    table2 += "<td>";
                    table2 += customer.getLastName();
                    table2 += "</td>";
                    
                    
                    table2 += "<td>";
                    table2 += customer.getEmailAddr();
                    table2 += "</td>";
                    
                    table2 += "</tr>";
                    
                }       
            } catch (SQLException ex) {
                Logger.getLogger(ReadQuery2.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   
        table2 += "</table>";
  
        return table2;
   
   
   
   }
}

   