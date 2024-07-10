/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author DELL
 */
public class BookingDetail {
    private String BookingId;
    private String ServiceID;
    private String CabinID;

    private double price;
    private String PetID;

    public BookingDetail(String BookingId, String ServiceID, String CabinID, double price, String PetID) {
        this.BookingId = BookingId;
        this.ServiceID = ServiceID;
        this.CabinID = CabinID;
        this.price = price;
        this.PetID = PetID;
    }

    @Override
    public String toString() {
        return "BookingDetail{" + "BookingId=" + BookingId + ", ServiceID=" + ServiceID + ", CabinID=" + CabinID + ", price=" + price + ", PetID=" + PetID + '}';
    }

    
    
    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String BookingId) {
        this.BookingId = BookingId;
    }

    public String getServiceID() {
        return ServiceID;
    }

    public void setServiceID(String ServiceID) {
        this.ServiceID = ServiceID;
    }

    public String getCabinID() {
        return CabinID;
    }

    public void setCabinID(String CabinID) {
        this.CabinID = CabinID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPetID() {
        return PetID;
    }

    public void setPetID(String PetID) {
        this.PetID = PetID;
    }
    
    
}
