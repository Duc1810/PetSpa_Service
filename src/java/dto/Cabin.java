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
public class Cabin {
    private  String cabinId;
    private String typeCabin;
    private String size;
    private String image;
    private double price;
    private int amount;
    private int status;

    public Cabin(String cabinId, String typeCabin, String size, String image, double price, int amount, int status) {
        this.cabinId = cabinId;
        this.typeCabin = typeCabin;
        this.size = size;
        this.image = image;
        this.price = price;
        this.amount = amount;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

    public String getCabinId() {
        return cabinId;
    }

    public void setCabinId(String cabinId) {
        this.cabinId = cabinId;
    }

    public String getTypeCabin() {
        return typeCabin;
    }

    public void setTypeCabin(String typeCabin) {
        this.typeCabin = typeCabin;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cabin{" + "cabinId=" + cabinId + ", typeCabin=" + typeCabin + ", size=" + size + ", image=" + image + ", price=" + price + ", amount=" + amount + '}';
    }
    
    
}
