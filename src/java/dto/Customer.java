/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author DELL
 */

import java.sql.Date;

public class Customer {
    private String cussId;
    private String FirstName;
    private String LastName;
    private String Gender;
    private Date Birthday;
    private String Address;
    private String PhoneNumber;
    private String accID;

    public Customer(String cussId, String FirstName, String LastName, String Gender, Date Birthday, String Address, String PhoneNumber, String accID) {
        this.cussId = cussId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.Birthday = Birthday;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.accID = accID;
    }

    public String getCussId() {
        return cussId;
    }

    public void setCussId(String cussId) {
        this.cussId = cussId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    @Override
    public String toString() {
        return "Customer{" + "cussId=" + cussId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Gender=" + Gender + ", Birthday=" + Birthday + ", Address=" + Address + ", PhoneNumber=" + PhoneNumber + ", accID=" + accID + '}';
    }

   
    
    
}
