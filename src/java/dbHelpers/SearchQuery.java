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

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
    
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    
    
    public String getHTMLtable(){
            String table = "";
            table += "<table>";
            
            table += "<tr>";
                
                table +="<th>";
                table += "Customer ID";
                table +="</th>";

                table +="<th>";
                table += "First Name";
                table +="</th>";
                
                table +="<th>";
                table += "Last Name";
                table +="</th>";
                
                table +="<th>";
                table += "Address1";
                table +="</th>";
                
                table +="<th>";
                table += "Address2";
                table +="</th>";
                
                table +="<th>";
                table += "City";
                table +="</th>";
                
                table +="<th>";
                table += "State";
                table +="</th>";
                
                table +="<th>";
                table += "Zip";
                table +="</th>";
                
                table +="<th>";
                table += "Email";
                table +="</th>";
                        
                table += "</tr>";
                
        try {
            while (this.results.next()){
            
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
                
                
                table += "<tr>";
                
                table += "<td>";
                table += customer.getCustID();
                table += "</td>";
                
                table += "<td>";
                table += customer.getFirstName();
                table += "</td>";
                
                table += "<td>";
                table += customer.getLastName();
                table += "</td>";
                
                 table += "<td>";
                table += customer.getCustAddr1();
                table += "</td>";
                
                 table += "<td>";
                table += customer.getCustAddr2();
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
                    table += "<a href=update?custID=" + customer.getCustID() + "><font color = 'black'> Update </font></a>" + "<a href=delete?custID=" + customer.getCustID() + "><font color = 'black'> Delete </font></a>";
                    table += "</td>";
                    
                table += "</tr>";
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            table +="</table>";
            return table;
                   
        
        }
    
    }
    
    
