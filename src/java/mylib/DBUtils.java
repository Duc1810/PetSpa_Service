/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LONG
 */
public class DBUtils {
    public static Connection  makeConnection() throws Exception{
        Connection cn=null;
        String IP="localhost";
        String instanceName="DESKTOP-S41VFN3";
//        DESKTOP-S41VFN3\\PIEDTEAM
        String port="1433";
        String uid="sa";
        String pwd="12345";
        String db="PETCARESYSTEM";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://" +IP+"\\"+ instanceName+":"+port
                 +";databasename="+db+";user="+uid+";password="+pwd;
        Class.forName(driver);
        cn=DriverManager.getConnection(url);
        return cn;
    }
    public static void main(String[] args) throws Exception {
        DBUtils cc = new DBUtils();
         System.out.println(cc.makeConnection());
    }
}
//    public static Connection  makeConnection() throws Exception{
//        Connection cn=null;
//        String IP="localhost";
//        String instanceName="DESKTOP-IRCVITT";
//        String port="1433";
//        String uid="sa";
//        String pwd="12345";
//        String db="DBJAVAWEB";
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url="jdbc:sqlserver://" +IP+"\\"+ instanceName+":"+port
//                 +";databasename="+db+";user="+uid+";password="+pwd;
//        Class.forName(driver);
//        cn=DriverManager.getConnection(url);
//        return cn;
//    }

