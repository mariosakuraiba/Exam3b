
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

public class ReadQuery {
    
        private Connection conn;
        private ResultSet results;
              
   public ReadQuery(){
       
   Properties props = new Properties();
   InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   String driver = props.getProperty("driver.name");
   String url = props.getProperty("server.name");
   String username = props.getProperty("user.name");
   String passwd = props.getProperty("user.password");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url,username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
   
   public void doRead(){
        
        
            try {
                String query = "select * from Customers ORDER BY custID ASC";
                
                PreparedStatement ps = conn.prepareStatement(query);
                this.results = ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
   
   
   public String getHTMLTable(){
   
                
        String table = "";
   
   
        table += "<table class= 'tableformat'>";
   
   
 
  
        table += "<tr class='tablehead'>";
        table += "<th>custID</th>";
        table += "<th>firstName</th>";
        table += "<th>lastName</th>";
        table += "<th>addr1</th>";
        table += "<th>addr2</th>";
        table += "<th>custCity</th>";
        table += "<th>custState</th>";
        table += "<th>custZip</th>";
        table += "<th>emailAddr</th>";

        table += "</tr>";

   
   
   
           
            try {
                while(this.results.next()){
                    
                    Customers customer = new Customers();
                    customer.setCustID(this.results.getInt("custID"));
                    customer.setFirstName(this.results.getString("firstName"));
                    customer.setLastName(this.results.getString("lastName"));
                    customer.setAddr1(this.results.getString("addr1"));
                    customer.setAddr2(this.results.getString("addr2"));
                    customer.setCustCity(this.results.getString("custCity"));
                    customer.setCustState(this.results.getString("custState"));
                    customer.setCustZip(this.results.getString("custZip"));
                    customer.setEmailAddr(this.results.getString("emailAddr"));
                    
                    
                    table += "<tr>";
                    table += "<td>";
                    table +=  customer.getCustID();
                    table += "</td>";
                    
                    table += "<td>";
                    table +=  customer.getFirstName();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getLastName();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getAddr1();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getAddr2();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getCustCity();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getCustState();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getCustZip();
                    table += "</td>";
                    
                    table += "<td>";
                    table += customer.getEmailAddr();
                    table += "</td>";
                    
                    
                    table += "<td>";
                    table += "<a href=update?custID=" + customer.getCustID() + "><font color = 'black'> Detail/ </font></a>" + "<a href=delete?custID=" + customer.getCustID() + "><font color = 'black'> Delete </font></a>";
                    table += "</td>";
                    
                    
                    table += "</tr>";
                    
                }       
            } catch (SQLException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   
        table += "</table>";
  
        return table;
   
   
   
   }
   
   
}
