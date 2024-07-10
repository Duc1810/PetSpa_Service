/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Pet {
    private String petID;
    private String name;
    private Date birthday;
    private String gender;
    private String color;
    private float  height;
    private float width;
    private float weight;
    private String image;
    private int status;
    private String type;
    private String CusID;

    public String getPetID() {
        return petID;
    }

    public Pet(String petID, String name, Date birthday, String gender, String color, float height, float width, float weight, String image, int status, String type, String CusID) {
        this.petID = petID;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.color = color;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.image = image;
        this.status = status;
        this.type = type;
        this.CusID = CusID;
    }

 

    @Override
    public String toString() {
        return "Pet{" + "petID=" + petID + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", color=" + color + ", height=" + height + ", width=" + width + ", weight=" + weight + ", image=" + image + ", status=" + status + ", type=" + type + ", CusID=" + CusID + '}';
    }
    

    public void setPetID(String petID) {
        this.petID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }
    
    
    
}
