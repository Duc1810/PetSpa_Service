/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import dto.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author DELL
 */
public class CustomerDAO {
    
    public ArrayList<Customer> getCusts() {
        ArrayList<Customer> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [CustID], [FirstName], [LastName], [Gender], [Birthday], [Address], [PhoneNumber], [AccID]\n"
                        + "FROM [dbo].[Customer]";
                Statement st = cn.createStatement();
                ResultSet table = st.executeQuery(sql);
                if (table != null) {
                    while (table.next()) {
                        String custID = table.getString("CustID");
                        String firstName = table.getString("FirstName");
                        String lastName = table.getString("LastName");
                        String gender = table.getString("Gender");
                        Date birth = table.getDate("Birthday");
                        String address = table.getString("Address");
                        String phone = table.getString("PhoneNumber");
                        String accID = table.getString("AccID");
                        Customer cs = new Customer(custID, firstName, lastName, gender, birth, address, phone, accID);
                        list.add(cs);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
    public int createCustomer(Customer cus,Boolean status){       
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
//                INSERT INTO Customer VALUES('CUS00000', N'An', N'Nguyễn',
//N'Nam', '19990412', N'58/9 Đ. Trương Văn Thành, Hiệp Phú, Quận 9, Tp.HCM', '0900201001', 'ACC00000')
                String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, cus.getCussId().trim());
                pst.setString(2, cus.getFirstName());
                pst.setString(3, cus.getLastName());
                pst.setString(4, cus.getGender());
                pst.setDate(5, cus.getBirthday());
                pst.setString(6, cus.getAddress());
                pst.setString(7, cus.getPhoneNumber());
                pst.setString(8, cus.getAccID());
                result = pst.executeUpdate();
            }
            
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }
    public String checkPhone (String phone){
        String result = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select CustID From Customer where PhoneNumber = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, phone);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    result = table.getString("CustID");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public Customer getCustomer ( String accid){
        String result = null;
        Connection cn = null;
        Customer cs = null;
        int res = 0; 
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [CustID], [FirstName], [LastName], [Gender], [Birthday], [Address], [PhoneNumber], [AccID] FROM  Customer where AccID = ?";
               
                 PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, accid);
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while(table.next()){
                        String custID = table.getString("CustID");
                        String firstName = table.getString("FirstName");
                        String lastName = table.getString("LastName");
                        String gender = table.getString("Gender");
                        Date birth = table.getDate("Birthday");
                        String address = table.getString("Birthday");
                        String phone = table.getString("Address");
                        String accID = table.getString("AccID");
                         cs = new Customer(custID, firstName, lastName, gender, birth, address, phone, accID);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cs;
    }
    public int getIdMax() {
        String result = null;
        Connection cn = null;
        int res = 0; 
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select CustID from Customer  where CustID   >=ALL (select CustID  from Customer)";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    result = table.getString("CustID");
                   
                }
                String st = result.substring(3);
                    res = Integer.parseInt(st);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
        public int updatePhone(String custID, String newPhone) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Customer]\n"
                        + "SET [PhoneNumber] = ?\n"
                        + "WHERE [CustID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newPhone);
                pst.setString(2, custID);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //update address
    public int updateAddress(String custID, String newAddress) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Customer]\n"
                        + "SET [Address] = ?\n"
                        + "WHERE [CustID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newAddress);
                pst.setString(2, custID);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //update birthday
    public int updateBirth(String custID, Date newBirth) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Customer]\n"
                        + "SET [Birthday] = ?\n"
                        + "WHERE [CustID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setDate(1, newBirth);
                pst.setString(2, custID);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //update gender
    public int updateGender(String custID, String newGender) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Customer]\n"
                        + "SET [Gender] = ?\n"
                        + "WHERE [CustID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newGender);
                pst.setString(2, custID);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //update first name
    public int updateFirstName(String custID, String newFirstName) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Customer]\n"
                        + "SET [FirstName] = ?\n"
                        + "WHERE [CustID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newFirstName);
                pst.setString(2, custID);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //update last name 
    public int updateLastName(String custID, String newLastName) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Customer]\n"
                        + "SET [LastName] = ?\n"
                        + "WHERE [CustID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newLastName);
                pst.setString(2, custID);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        CustomerDAO c =  new CustomerDAO();
        System.out.println(c.getIdMax());
//        System.out.println(c.checkPhone("0707511398"));
        System.out.println(c.getCustomer("ACC00001"));
        ArrayList<Customer> list = c.getCusts();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}
