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
public class PetType {
    private String Id;
    private String descriptive;
    private String image;

    public PetType(String Id, String descriptive, String image) {
        this.Id = Id;
        this.descriptive = descriptive;
        this.image = image;
    }

    public PetType() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getDescriptive() {
        return descriptive;
    }

    public void setDescriptive(String descriptive) {
        this.descriptive = descriptive;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
