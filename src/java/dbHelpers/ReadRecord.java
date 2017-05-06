
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

public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Customers customer = new Customers();
    private int custID; 
    
    public ReadRecord (int custID){
    
    Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.custID = custID;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    
    public void doRead(){

    
       
        PreparedStatement ps  = null;
        try {
            String query  = "SELECT * FROM customers WHERE custID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1,custID);
            this.results = ps.executeQuery();
            this.results.next();
            customer.setCustID(this.results.getInt("custID"));
            customer.setFirstName(this.results.getString("firstName"));
            customer.setLastName(this.results.getString("lastName"));
            customer.setCustAddr1(this.results.getString("custAddr1"));
            customer.setCustAddr2(this.results.getString("custAddr2"));
            customer.setCustCity(this.results.getString("custCity"));
            customer.setCustState(this.results.getString("custState"));
            customer.setCustZip(this.results.getString("custZip"));
            customer.setEmailAddr(this.results.getString("emailAddr"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }
    
    public Customers getCustomer(){
    
        return this.customer;
    }
        
        

}
    

