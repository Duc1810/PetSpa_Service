/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DT;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class UI {


    
    

    public static String generateId(String info, int id) {
//<!--                            <input type="hidden" value="${it.cabinId}" name="txtCabinId"/>-->
        String accountId = info.toUpperCase().trim() + String.format("%05d", ++id);

        return accountId;
    }
     public static String generateIdBooking(String info, int id) {
//<!--                            <input type="hidden" value="${it.cabinId}" name="txtCabinId"/>-->
        String accountId = info.toUpperCase().trim() + String.format("%06d", ++id);

        return accountId;
    }

    public static Date date() {
        LocalDate ngayHienTai = LocalDate.now();
        Date ngaySQL = Date.valueOf(ngayHienTai);
        return ngaySQL;
    }

    public static boolean FormEmail(String email) {

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean FormPassword(String password) {

        String regex1 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        UI c = new UI();
        System.out.println(c.FormEmail("NguyenbabN1234@@@"));
        System.out.println(c.date());
        System.out.println(UI.generateId("ACC", 102));
        System.out.println(UI.generateIdBooking("ACC", 102));
    }
}
