/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Booking {
    private String bookingID;
    private String CusID;
    private Date startDate;
    private Date schedule;
    private int status;
    private double total;
    private String rate;
    private String comment;
    private ArrayList<BookingDetail> list;

    public Booking(String bookingID, String CusID, Date startDate, Date schedule, int status, double total, String rate, String comment, ArrayList<BookingDetail> list) {
        this.bookingID = bookingID;
        this.CusID = CusID;
        this.startDate = startDate;
        this.schedule = schedule;
        this.status = status;
        this.total = total;
        this.rate = rate;
        this.comment = comment;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID + ", CusID=" + CusID + ", startDate=" + startDate + ", schedule=" + schedule + ", status=" + status + ", total=" + total + ", rate=" + rate + ", comment=" + comment + ", list=" + list + '}';
    }

   

   

    
        
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
