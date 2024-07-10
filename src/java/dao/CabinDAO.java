/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cabin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

/**
 *
 * @author DELL
 */
public class CabinDAO {

    public ArrayList<Cabin> getCabins() throws Exception {
        Connection cn = null;
        ArrayList<Cabin> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [CabinID],[TypeCabin],[Size],[Image],[Price],[Amount], Status FROM Cabin ";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String cabinid = table.getString("CabinID");
                        String type = table.getString("TypeCabin");
                        String size = table.getString("Size");
                        String imageurl = table.getString("Image");
                        double price = table.getDouble("Price");
                        int amount = table.getInt("Amount");
                        int status = table.getInt("Status");
                        Cabin cb = new Cabin(cabinid, type, size, imageurl, price, amount, status);
                        list.add(cb);
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
    
     public ArrayList<Cabin> getCabins(String findCabin) {
        ArrayList<Cabin> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [CabinID], [TypeCabin], [Size], [Image], [Price], [Amount], [Status]\n"
                        + "FROM [dbo].[Cabin]\n"
                        + "WHERE [Status] = 1 AND [TypeCabin] LIKE ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + findCabin + "%");
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String cabinId = table.getString("CabinID");
                        String typeCabin = table.getString("TypeCabin");
                        String size = table.getString("Size");
                        String urlImage = table.getString("Image");
                        float price = table.getFloat("Price");
                        int amount = table.getInt("Amount");
                        int status = table.getInt("Status");
                        list.add(new Cabin(cabinId, typeCabin, size, urlImage, price, amount, status));
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
    
     public int createCabin(Cabin naccount, Boolean status) {

        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
//                insert Account values ('ACC00005','anh','nguyen','01-01-2023','dfsf@gmail.com','Customer','true');
                String sql = "insert Cabin values (?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, naccount.getCabinId().trim());
                pst.setString(2, naccount.getTypeCabin().trim());
                pst.setString(3, naccount.getSize());
                
                pst.setString(4, naccount.getImage().trim());
                pst.setDouble(5, naccount.getPrice());
                pst.setInt(6, naccount.getAmount());
                pst.setInt(7, naccount.getStatus());
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
    public ArrayList<Cabin> getCabinsCatergory(String name) throws Exception {
        Connection cn = null;
        ArrayList<Cabin> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [CabinID],[TypeCabin],[Size],[Image],[Price],[Amount], Status FROM Cabin  where TypeCabin =? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String cabinid = table.getString("CabinID");
                        String type = table.getString("TypeCabin");
                        String size = table.getString("Size");
                        String imageurl = table.getString("Image");
                        double price = table.getDouble("Price");
                        int amount = table.getInt("Amount");
                        int status = table.getInt("Status");
                        Cabin cb = new Cabin(cabinid, type, size, imageurl, price, amount, status);
                        list.add(cb);
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

    public int getToalAccount() throws Exception {
        int result = 0;
        Connection cn = null;
        ArrayList<Cabin> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select count(*) from Cabin";
                PreparedStatement st = cn.prepareStatement(sql);

                ResultSet rs = st.executeQuery();
                while (rs.next()) {

                    result = rs.getInt(1);
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
        return result;
    }

    public ArrayList<Cabin> pagingAccount(int index) throws Exception {
        Connection cn = null;
        ArrayList<Cabin> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "Select* from Cabin\n"
                        + "Order by  CabinID  asc\n"
                        + "OFfset ? rows fetch next 9 rows only";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, (index - 1) * 9);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String cabinid = table.getString("CabinID");
                        String type = table.getString("TypeCabin");
                        String size = table.getString("Size");
                        String imageurl = table.getString("Image");
                        double price = table.getDouble("Price");
                        int amount = table.getInt("Amount");
                         int status = table.getInt("Status");
                        Cabin cb = new Cabin(cabinid, type, size, imageurl, price, amount, status);
                        list.add(cb);
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

    public Cabin getItem(String itemId) throws Exception {
        Connection cn = null;
        Cabin it = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [CabinID],[TypeCabin] ,[Size],[Image] ,[Price],[Amount], Status\n"
                        + "FROm Cabin \n"
                        + "where CabinID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, itemId);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    String cabinid = table.getString("CabinID");
                    String type = table.getString("TypeCabin");
                    String size = table.getString("Size");
                    String imageurl = table.getString("Image");
                    double price = table.getDouble("Price");
                    int amount = table.getInt("Amount");
                     int status = table.getInt("Status");
                    it = new Cabin(cabinid, type, size, imageurl, price, amount, status);
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

    public ArrayList<Cabin> getSize(int value) throws Exception {
        ArrayList<Cabin> list = new ArrayList<>();
        Connection cn = null;
        Cabin it = null;
        String to = null;
        String from = null;
        if (value == 1) {
            to = "32";
            from = "42";
        }
        if (value == 2) {
            to = "50";
            from = "55";
        }
        if (value == 3) {
            to = "65";
            from = "80";
        }
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select  [CabinID],[TypeCabin] ,[Size],[Image] ,[Price],[Amount], Status from Cabin where Size like ? or size like  ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%"+to+"%");
                pst.setString(2, "%"+from+"%");
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String cabinid = table.getString("CabinID");
                        String type = table.getString("TypeCabin");
                        String size = table.getString("Size");
                        String imageurl = table.getString("Image");
                        double price = table.getDouble("Price");
                        int amount = table.getInt("Amount");
                         int status = table.getInt("Status");
                        Cabin cb = new Cabin(cabinid, type, size, imageurl, price, amount, status);
                        list.add(cb);
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

    public static void main(String[] args) throws Exception {
        CabinDAO c = new CabinDAO();
        ArrayList<Cabin> list = c.getCabins("a");
        for (Cabin cabin : list) {
            System.out.println(cabin);
        }
        System.out.println(c.createCabin(new Cabin("1234", "342", "234", "34", 134, 34, 1), Boolean.TRUE));
//        System.out.println(c.getToalAccount());
//        System.out.println(c.getItem("CB000001"));
    }
}
