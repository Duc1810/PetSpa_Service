








package dao;

import DT.UI;
import dto.Account;
import dto.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mylib.DBUtils;
import java.security.SecureRandom;

/**
 *
 * @author LONG
 */
public class AccountDAO {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";
    private static int idacc = 5;

    public Account getAccount(String email, String password) {
        Account result = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String url = "SELECT [AccountID], [UserName], [Password], [SignDate], [Email], [Role], [Status]\n"
                        + "FROM [dbo].[Account] WHERE [Status] = 1 AND [Email] = ? AND [Password] = ? \n"
                        + "COLLATE SQL_Latin1_General_CP1_CI_AS";
                PreparedStatement pst = cn.prepareStatement(url);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet table = pst.executeQuery();

                if (table != null && table.next()) {
                    String m_accID = table.getString("AccountID");
                    String m_userName = table.getString("UserName");
                    String m_password = table.getString("Password");
                    Date m_signDate = table.getDate("SignDate");
                    String m_email = table.getString("Email");
                    String m_role = table.getString("Role");
                    result = new Account(m_accID, m_userName, m_password, m_signDate, m_email, m_role);
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

    public int getIdMax() {
        String result = null;
        Connection cn = null;
        int res = 0; 
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [AccountID] from Account  where AccountID   >=ALL (select AccountID from Account)";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    result = table.getString("AccountID");
                   
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

    public String checkEmail(String email) {
        String result = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select AccountID From Account where Email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    result = table.getString("AccountID");

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
      public String checkUsername(String user) {
        String result = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select AccountID From Account where UserName = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, user);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    result = table.getString("AccountID");

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
    

    public int createAccount(Account naccount, Boolean status) {

        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
//                insert Account values ('ACC00005','anh','nguyen','01-01-2023','dfsf@gmail.com','Customer','true');
                String sql = "insert Account values (?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, naccount.getAccID().trim());
                pst.setString(2, naccount.getUserName().trim());
                pst.setString(3, naccount.getPass());
                pst.setDate(4, DT.UI.date());
                pst.setString(5, naccount.getEmail().trim());
                pst.setString(6, naccount.getRole());
                pst.setBoolean(7, status);
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

    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AccountDAO d = new AccountDAO();
        CustomerDAO c = new CustomerDAO();
//        System.out.println(d.getAccount("annguy12@gmail.com", "Nguyenan1204"));
//        System.out.println(d.checkEmail("annguy12@gmail.com"));
//        Date st = Date.valueOf("2024-08-08");
        Account acc = new Account("ACC00021", "Duck222", "ducnguyen1111", UI.date(), "kimloan2222@gmail.com", "Customer");
//        System.out.println(d.createAccount(acc, Boolean.TRUE));
        String accid = UI.generateId("ACC", d.getIdMax());
        System.out.println(accid);
//'CUS00000', N'An', N'Nguyễn',
//N'Nam', '19990412', N'58/9 Đ. Trương Văn Thành, Hiệp Phú, Quận 9, Tp.HCM', '0900201001', 'ACC00000')
//       Customer cs = new Customer("CUS00000", "An", "Nguyễn","Nam", UI.date(), "Huynh Tan Phat", "0900201002","ACC00008");
//        System.out.println(c.createCustomer(cs, Boolean.TRUE));
//       

    }

}
