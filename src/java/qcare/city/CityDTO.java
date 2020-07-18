/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.city;

/**
 *
 * @author DELL
 */
public class CityDTO {
    private int Postcode;
    private String Name;

    public CityDTO() {
    }

    public CityDTO(int Postcode, String Name) {
        this.Postcode = Postcode;
        this.Name = Name;
    }

    public int getPostcode() {
        return Postcode;
    }

    public void setPostcode(int Postcode) {
        this.Postcode = Postcode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
