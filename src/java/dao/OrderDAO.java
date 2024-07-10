/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DT.UI;
import dto.Booking;
import dto.BookingDetail;
import dto.Cabin;
import dto.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mylib.DBUtils;

/**
 *
 * @author DELL
 */
public class OrderDAO {

    public int insert() {
        String id = UI.generateIdBooking("BK", getIdMax());
        ArrayList<BookingDetail> list = new ArrayList<>();
        Booking b = new Booking(id, "CUS00001", UI.date(), UI.date(), 1, 2300000.00, "Good", "Good", list);
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();

            if (cn != null) {
                String sql = "insert Booking values (?,?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, "CUS00001");
                pst.setDate(3, UI.date());
                pst.setDate(4, UI.date());
                pst.setInt(5, 1);
                pst.setDouble(6, 1000000.0);
                pst.setString(7, "Good");
                pst.setString(8, "Good");
                result = pst.executeUpdate();
            }

        } catch (Exception e) {

        }
        return result;
    }

    public int insertBooking(String accid, Date datesche, String rate, String comment, double totalmoney, HashMap<Cabin, String> giohangcabin, HashMap<Service, String> giohangservice) throws Exception {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String id = UI.generateIdBooking("BK", getIdMax());
            if (cn != null) {

                String sql = "insert Booking values (?,?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, accid);
                pst.setDate(3, UI.date());
                pst.setDate(4, UI.date());
                pst.setInt(5, 1);
                pst.setDouble(6, totalmoney);
                pst.setString(7, rate);
                pst.setString(8, comment);
                result = pst.executeUpdate();
                if (result > 0) {
                    sql = "Select top 1 BookingID from Booking order by BookingID desc";
                    pst = cn.prepareCall(sql);
                    ResultSet table = pst.executeQuery();
                    if (table != null && table.next()) {
                        String orderid = table.getString("BookingID");
                        if (orderid != null) {
                            //insert các items vào orderdetail
                            if (giohangcabin != null) {
                                for (Map.Entry<Cabin, String> entry : giohangcabin.entrySet()) {
                                    sql = "insert BookingDetailCabin values(?,?,?,?)";
                                    pst = cn.prepareCall(sql);
                                    pst.setString(1, orderid);
                                    pst.setString(2, entry.getKey().getCabinId());
                                    pst.setDouble(3, entry.getKey().getPrice());
                                    pst.setString(4, entry.getValue());
                                    result = pst.executeUpdate();
                                }
                            }
                            if (giohangservice != null) {
                                for (Map.Entry<Service, String> entry : giohangservice.entrySet()) {
                                    sql = "insert BookingDetail values(?,?,?,?)";
                                    pst = cn.prepareCall(sql);
                                    pst.setString(1, orderid);
                                    pst.setString(2, entry.getKey().getServiceID());
                                    pst.setDouble(3, entry.getKey().getPrice());
                                    pst.setString(4, entry.getValue());
                                    result = pst.executeUpdate();
                                }
                            }
                        }
                    }
                    //lấy orderid vừa chèn
                    //insert orderdetail
                }
            }
        } catch (SQLException e) {
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

    public int getIdMax() {
        String result = null;
        Connection cn = null;
        int res = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [BookingID] from Booking  where BookingID   >=ALL (select BookingID from Booking)";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    result = table.getString("BookingID");

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

    public static void main(String[] args) {
        OrderDAO o = new OrderDAO();
//         System.out.println(UI.generateIdBooking("BK", o.getIdMax()));
        System.out.println(o.insert());
    }

}
