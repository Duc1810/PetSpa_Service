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
public class Service {
    private String serviceID;
    private String name;
    private double price;
    private int status;
    private String imageURL;

    public Service(String serviceID, String name, double price, int status, String imageURL) {
        this.serviceID = serviceID;
        this.name = name;
        this.price = price;
        this.status = status;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    

    

    public Service() {
    }

    @Override
    public String toString() {
        return "Service{" + "serviceID=" + serviceID + ", name=" + name + ", price=" + price + ", status=" + status + ", imageURL=" + imageURL + '}';
    }

    
    
    

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
    
}
