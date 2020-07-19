/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.has;

/**
 *
 * @author DELL
 */
public class HasDTO {
    private int Clinic;
    private int Specialist;

    public HasDTO() {
    }

    public HasDTO(int Clinic, int Specialist) {
        this.Clinic = Clinic;
        this.Specialist = Specialist;
    }

    public int getClinic() {
        return Clinic;
    }

    public void setClinic(int Clinic) {
        this.Clinic = Clinic;
    }

    public int getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(int Specialist) {
        this.Specialist = Specialist;
    }
    
    
}
