/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.clinic;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author DELL
 */
public class ClinicDTO implements Serializable{
    private int ID;
    private String Name;
    private String Address;
    private int City;
    private String Phone;
    private Time OpenTime;
    private Time CloseTime;

    public ClinicDTO() {
    }

    public ClinicDTO(int ID, String Name, String Address, int City, String Phone, Time OpenTime, Time CloseTime) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.City = City;
        this.Phone = Phone;
        this.OpenTime = OpenTime;
        this.CloseTime = CloseTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getCity() {
        return City;
    }

    public void setCity(int City) {
        this.City = City;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Time getOpenTime() {
        return OpenTime;
    }

    public void setOpenTime(Time OpenTime) {
        this.OpenTime = OpenTime;
    }

    public Time getCloseTime() {
        return CloseTime;
    }

    public void setCloseTime(Time CloseTime) {
        this.CloseTime = CloseTime;
    }
    
    
}
