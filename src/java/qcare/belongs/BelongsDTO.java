/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.belongs;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class BelongsDTO implements Serializable{
    private int Specialist;
    private int Symptom;

    public BelongsDTO() {
    }

    public BelongsDTO(int Specialist, int Symptom) {
        this.Specialist = Specialist;
        this.Symptom = Symptom;
    }

    public int getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(int Specialist) {
        this.Specialist = Specialist;
    }

    public int getSymptom() {
        return Symptom;
    }

    public void setSymptom(int Symptom) {
        this.Symptom = Symptom;
    }
    
    
}
