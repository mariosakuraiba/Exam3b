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

public class SearchQuery2 {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery2(){
    
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSearch(String firstName){
    
        try {
            String query = "SELECT * FROM customers WHERE UPPER(firstName) LIKE ? OR UPPER(lastName) LIKE ?) ORDER BY custID ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, "%" + firstName.toUpperCase() +"%");
            ps.setString(2, "%" + firstName.toUpperCase() + "%");
            
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery2.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    
    
    public String getHTMLtable2(){
            String table2 = "";
            table2 += "<table>";
            
            table2 += "<tr>";
                
                table2 +="<th>";
                table2 += "Customer ID";
                table2 +="</th>";

                table2 +="<th>";
                table2 += "First Name";
                table2 +="</th>";
                
                table2 +="<th>";
                table2 += "Last Name";
                table2 +="</th>";
                
                table2 +="<th>";
                table2 += "Email";
                table2 +="</th>";
                        
                table2 += "</tr>";
                
        try {
            while (this.results.next()){
            
                Customers customer = new Customers();
                customer.setCustID(this.results.getInt("custID"));
                customer.setFirstName(this.results.getString("firstName"));
                customer.setLastName(this.results.getString("lastName"));
                customer.setEmailAddr(this.results.getString("emailAddr"));
                
                
                table2 += "<tr>";
                
                table2 += "<td>";
                table2 += customer.getCustID();
                table2 += "</td>";
                
                table2 += "<td>";
                table2 += customer.getFirstName();
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
            Logger.getLogger(SearchQuery2.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            table2 +="</table>";
            return table2;
                   
        
        }
    
    }
    