/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author LONG
 */
public class Account {
    private String accID;
    private String userName;
    private String pass;
    private Date signDate;
    private String email;
    private String role;
    private int status;

    public Account() {
    }

    public Account(String accID, String userName, String pass, Date signDate, String email, String role) {
        this.accID = accID;
        this.userName = userName;
        this.pass = pass;
        this.signDate = signDate;
        this.email = email;
        this.role = role;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccid(String accID) {
        this.accID = accID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
  

    @Override
    public String toString() {
        return "Account{" + "accID=" + accID + ", userName=" + userName + ", pass=" + pass + ", signDate=" + signDate + ", email=" + email + ", role=" + role + ", status=" + status + '}';
    }
    
}
