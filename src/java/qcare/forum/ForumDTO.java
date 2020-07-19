/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.forum;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ForumDTO implements Serializable{
    private String Doctor;
    private int Comment;

    public ForumDTO() {
    }

    public ForumDTO(String Doctor, int Comment) {
        this.Doctor = Doctor;
        this.Comment = Comment;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }

    public int getComment() {
        return Comment;
    }

    public void setComment(int Comment) {
        this.Comment = Comment;
    }
    
    
}
