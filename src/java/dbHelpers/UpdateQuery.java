package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

public class UpdateQuery {
    
    private Connection conn;
    public UpdateQuery(){
    
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doUpdate(Customers customer) {
        
       
        try {
            String query = "UPDATE customers SET firstName = ?, lastName = ?, custAddr1 = ?, custAddr2 = ?,custCity = ?,custState = ?,custZip= ?,emailAddr = ? WHERE custID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, customer.getFirstName());
            ps.setString(2,customer.getLastName());
            ps.setString(3,customer.getCustAddr1());
            ps.setString(4,customer.getCustAddr2());
            ps.setString(5,customer.getCustCity());
            ps.setString(6,customer.getCustState());
            ps.setString(7,customer.getCustZip());
            ps.setString(8,customer.getEmailAddr());
            ps.setInt(9,customer.getCustID());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
                
    
    }
    

