/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cabin;
import dto.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author DELL
 */
public class ServiceDAO {
    public ArrayList<Service> getServices() throws Exception {
        Connection cn = null;
        ArrayList<Service> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [ServiceID],[ServiceName],[Price],[ServiceStatus], [Image] FROM Services";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String id = table.getString("ServiceID");
                        String name = table.getString("ServiceName");
                        double price = table.getDouble("Price");
                        int status = table.getInt("ServiceStatus");
                        String imageURL = table.getString("Image");
                        Service service = new Service(id, name, price, status, imageURL);
                        list.add(service);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e);

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
    
    
    public int updatePrice(String serviceID, float newPrice) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Services]\n"
                        + "SET [Price] = ?\n"
                        + "WHERE [ServiceID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setFloat(1, newPrice);
                pst.setString(2, serviceID);
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
    
    public int updateStatus(String serviceID) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Services]\n"
                        + "SET [ServiceStatus] = 1 - (\n"
                        + "						SELECT [ServiceStatus] \n"
                        + "						FROM [dbo].[Services]\n"
                        + "						WHERE [ServiceID] = ?\n"
                        + "						)\n"
                        + "WHERE [ServiceID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, serviceID);
                pst.setString(2, serviceID);
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
    
    public Service getService(String itemId) throws Exception {
        Connection cn = null;
        Service it = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * FROM Services where ServiceID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, itemId);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    String cabinid = table.getString("ServiceID");
                    String name = table.getString("ServiceName");
                    double price = table.getDouble("Price");
                    int status = table.getInt("ServiceStatus");
                    String image = table.getString("Image");
                    it = new Service(cabinid, name, price, status, image);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return it;
    }
     public int createService(Service naccount) {

        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
//                insert Account values ('ACC00005','anh','nguyen','01-01-2023','dfsf@gmail.com','Customer','true');
                String sql = "insert Services values (?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, naccount.getServiceID().trim());
                pst.setString(2, naccount.getName().trim());
                pst.setDouble(3, naccount.getPrice());               
                pst.setInt(4, naccount.getStatus());
                pst.setString(5, naccount.getImageURL().trim());
                
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
    public static void main(String[] args) throws Exception {
        ServiceDAO s = new ServiceDAO();
        ArrayList<Service> list = s.getServices();
//        for (Service service : list) {
//            System.out.println(service);
//        }
//System.out.println(s.createService(new Service("23", "fuck", 234, 1, "dfasf")));
        System.out.println(s.getService("SV000001"));
        
    }
}
