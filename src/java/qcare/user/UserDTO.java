/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.user;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class UserDTO implements Serializable {

    private String Username;
    private String Password;
    private String Name;
    private int City;
    private int Role;
    private boolean Gender;
    private int Birthyear;
    private boolean AccountStatus;
    private int Specialist;

    public UserDTO(String Username, String Password, String Name, int City, int Role, boolean Gender, int Birthyear, boolean AccountStatus, int Specialist) {
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.City = City;
        this.Role = Role;
        this.Gender = Gender;
        this.Birthyear = Birthyear;
        this.AccountStatus = AccountStatus;
        this.Specialist = Specialist;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCity() {
        return City;
    }

    public void setCity(int City) {
        this.City = City;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public int getBirthyear() {
        return Birthyear;
    }

    public void setBirthyear(int Birthyear) {
        this.Birthyear = Birthyear;
    }

    public boolean isAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(boolean AccountStatus) {
        this.AccountStatus = AccountStatus;
    }

    public int getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(int Specialist) {
        this.Specialist = Specialist;
    }

}
