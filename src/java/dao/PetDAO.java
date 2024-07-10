/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DT.UI;
import dto.Customer;
import dto.Pet;
import dto.PetType;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author DELL
 */
public class PetDAO {

    public int createPet(Pet naccount) {

        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
//                insert Account values ('ACC00005','anh','nguyen','01-01-2023','dfsf@gmail.com','Customer','true');
                String sql = "insert Pet values (?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, naccount.getPetID().trim());
                pst.setString(2, naccount.getName().trim());
                pst.setDate(3, naccount.getBirthday());
                pst.setString(4, naccount.getGender());
                pst.setString(5, naccount.getColor().trim());
                pst.setFloat(6, naccount.getHeight());
                pst.setFloat(7, naccount.getWidth());
                pst.setFloat(8, naccount.getWeight());
                pst.setString(9, naccount.getImage());
                pst.setInt(10, naccount.getStatus());
                pst.setString(11, naccount.getType());
                pst.setString(12, naccount.getCusID());
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

    public int getIdMax() {
        String result = null;
        Connection cn = null;
        int res = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [PetID] from Pet  where PetID   >=ALL (select PetID from Pet)";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    result = table.getString("PetID");

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

    public ArrayList<Pet> getPetsByCus(String Cusid) {
        ArrayList<Pet> list = new ArrayList<>();
        Connection cn = null;
        Customer cs = null;
        int res = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [PetID], [PetName], [PetBirthday], [Gender], [Color], [PetHeight], [PetWidth], [PetWeight], \n"
                        + "[Image], [Status], [TypeOfPet], [CustID]\n"
                        + "FROM [dbo].[Pet] Where CustID = ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, Cusid);
                ResultSet table = pst.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String petID = table.getString("PetID");
                        String petName = table.getString("PetName");
                        Date petBirth = table.getDate("PetBirthday");
                        String gender = table.getString("Gender");
                        String color = table.getString("Color");
                        float petHeight = table.getFloat("PetHeight");
                        float petWidth = table.getFloat("PetWidth");
                        float petWeight = table.getFloat("PetWeight");
                        String image = table.getString("Image");
                        int status = table.getInt("Status");
                        String typeOfPet = table.getString("TypeOfPet");
                        String custID = table.getString("CustID");
                        Pet p = new Pet(petID, petName, petBirth, gender, color, petHeight, petWidth, petWeight, image, status, typeOfPet, custID);
                        list.add(p);
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

    public int createPetType(PetType naccount) {

        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
//                insert Account values ('ACC00005','anh','nguyen','01-01-2023','dfsf@gmail.com','Customer','true');
                String sql = "insert Pet values (?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, naccount.getId().trim());
                pst.setString(2, naccount.getDescriptive().trim());
                pst.setString(2, naccount.getImage().trim());
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

    public Pet getPet(String itemId) throws Exception {
        Connection cn = null;
        Pet it = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from Pet where PetID  =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, itemId);
                ResultSet table = pst.executeQuery();
                if (table != null && table.next()) {
                    String petID = table.getString("PetID");
                    String petName = table.getString("PetName");
                    Date petBirth = table.getDate("PetBirthday");
                    String gender = table.getString("Gender");
                    String color = table.getString("Color");
                    float petHeight = table.getFloat("PetHeight");
                    float petWidth = table.getFloat("PetWidth");
                    float petWeight = table.getFloat("PetWeight");
                    String image = table.getString("Image");
                    int status = table.getInt("Status");
                    String typeOfPet = table.getString("TypeOfPet");
                    String custID = table.getString("CustID");
                    it = new Pet(petID, petName, petBirth, gender, color, petHeight, petWidth, petWeight, image, status, typeOfPet, custID);
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

    public int updateWeight(String petID, float newWeight) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Pet]\n"
                        + "SET [PetWeight] = ?\n"
                        + "WHERE [PetID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setFloat(1, newWeight);
                pst.setString(2, petID);
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

    //update witdth
    public int updateWidth(String petID, float newWidth) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Pet]\n"
                        + "SET [PetWidth] = ?\n"
                        + "WHERE [PetID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setFloat(1, newWidth);
                pst.setString(2, petID);
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

    //update height
    public int updateHeight(String petID, float newHeight) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Pet]\n"
                        + "SET [PetHeight] = ?\n"
                        + "WHERE [PetID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setFloat(1, newHeight);
                pst.setString(2, petID);
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

    //update color
    public int updateColor(String petID, String newColor) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Pet]\n"
                        + "SET [Color] = ?\n"
                        + "WHERE [PetID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newColor);
                pst.setString(2, petID);
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
    public int updateGender(String petID, String newGender) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Pet]\n"
                        + "SET [Gender] = ?\n"
                        + "WHERE [PetID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newGender);
                pst.setString(2, petID);
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
    public int updateBirth(String petID, String newBirth) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Pet]\n"
                        + "SET [PetBirthday] = ?\n"
                        + "WHERE [PetID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newBirth);
                pst.setString(2, petID);
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

    public int updateStatus(String petID) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Pet] \n"
                        + "SET [Status] = 1 - (SELECT [Status] FROM [dbo].[Pet] WHERE [PetID] = ?)\n"
                        + "WHERE [PetID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, petID);
                pst.setString(2, petID);
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

    //update name 
    public int updatePetName(String petID, String newName) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Pet]\n"
                        + "SET [PetName] = ?\n"
                        + "WHERE [PetID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newName);
                pst.setString(2, petID);
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

    public static void main(String[] args) throws Exception {
        PetDAO p = new PetDAO();
        System.out.println(UI.generateId("PET", p.getIdMax()));
//        ArrayList<Pet> list = p.getPetsByCus("CUS00001");
//        for (Pet pet : list) {
//            System.out.println(pet);
//        }
//System.out.println(p.getService("PET00000"));
    }

}
