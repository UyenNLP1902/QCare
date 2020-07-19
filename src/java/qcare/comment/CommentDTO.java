/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.comment;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class CommentDTO implements Serializable{
    private int ID;
    private String MsgContent;
    private int PreviousID;
    private String Author;

    public CommentDTO() {
    }

    public CommentDTO(int ID, String msgContent, int PreviousID, String Author) {
        this.ID = ID;
        this.MsgContent = msgContent;
        this.PreviousID = PreviousID;
        this.Author = Author;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMsgContent() {
        return MsgContent;
    }

    public void setMsgContent(String msgContent) {
        this.MsgContent = msgContent;
    }

    public int getPreviousID() {
        return PreviousID;
    }

    public void setPreviousID(int PreviousID) {
        this.PreviousID = PreviousID;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
    
    
}
