
package model;

public class Customers {
    private int custID;
    private String firstName;
    private String lastName;
    private String custAddr1;
    private String custAddr2;
    private String custCity;
    private String custState;
    private String custZip;
    private String emailAddr;
    
     public Customers() {
        this.custID = 0;
        this.firstName = "";
        this.lastName = "";
        this.custAddr1 = "";
        this.custAddr2 = "";
        this.custCity = "";
        this.custState = "";
        this.custZip = "";
        this.emailAddr = "";
    }
    
    
    public Customers(int custID, String firstName, String lastName, String custAddr1, String custAddr2, String custCity, String custState, String custZip, String emailAddr) {
        this.custID = custID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.custAddr1 = custAddr1;
        this.custAddr2 = custAddr2;
        this.custCity = custCity;
        this.custState = custState;
        this.custZip = custZip;
        this.emailAddr = emailAddr;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustAddr1() {
        return custAddr1;
    }

    public void setCustAddr1(String custAddr1) {
        this.custAddr1 = custAddr1;
    }

    public String getCustAddr2() {
        return custAddr2;
    }

    public void setCustAddr2(String custAddr2) {
        this.custAddr2 = custAddr2;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getCustState() {
        return custState;
    }

    public void setCustState(String custState) {
        this.custState = custState;
    }

    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    @Override
    public String toString() {
        return "Customers{" + "custID=" + custID + ", firstName=" + firstName + ", lastName=" + lastName + ", custAddr1=" + custAddr1 + ", custAddr2=" + custAddr2 + ", custCity=" + custCity + ", custState=" + custState + ", custZip=" + custZip + ", emailAddr=" + emailAddr + '}';
    }
    
    
    
}
