
package model;

public class Customers {
    private int custID;
    private String firstName;
    private String lastName;
    private String addr1;
    private String addr2;
    private String custCity;
    private String custState;
    private String custZip;
    private String emailAddr;
    
     public Customers() {
        this.custID = 0;
        this.firstName = "";
        this.lastName = "";
        this.addr1 = "";
        this.addr2 = "";
        this.custCity = "";
        this.custState = "";
        this.custZip = "";
        this.emailAddr = "";
    }
    
    
    public Customers(int custID, String firstName, String lastName, String addr1, String addr2, String custCity, String custState, String custZip, String emailAddr) {
        this.custID = custID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addr1 = addr1;
        this.addr2 = addr2;
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

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
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
        return "Customers{" + "custID=" + custID + ", firstName=" + firstName + ", lastName=" + lastName + ", addr1=" + addr1 + ", addr2=" + addr2 + ", custCity=" + custCity + ", custState=" + custState + ", custZip=" + custZip + ", emailAddr=" + emailAddr + '}';
    }
    
    
    
}
