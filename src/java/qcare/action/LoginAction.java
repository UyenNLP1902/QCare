/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import java.sql.SQLException;
import java.util.Map;
import qcare.user.UserDAO;
import qcare.user.UserDTO;

/**
 *
 * @author DELL
 */
public class LoginAction {
    
    private String Username;
    private String Password;
    
    
    private final String error = "login.jsp";
    private final String success = "homepage.jsp";
    public LoginAction() {
    }

    @RequiredFieldValidator(type=ValidatorType.FIELD,
            message = "Username không thể để trống!")
    @StringLengthFieldValidator(type=ValidatorType.FIELD,
            maxLength = "50", message = "Username không thể dài quá 50 kí tự")
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    @RequiredFieldValidator(type=ValidatorType.FIELD,
            message = "Password không thể để trống!")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    public String execute() throws Exception {
       String url = error;
       try{
       UserDAO dao = new UserDAO();
       UserDTO user = dao.checkLogin(Username, Password);
       Map session = ActionContext.getContext().getSession();
       if(user!=null){
           url=success;
            session.put("ACCOUT", user);
       }
       else{
           String error="Username và password không đúng";
           session.put("Login_Error", error);
       }
       }catch(SQLException e){
           
       }
       return url;
    }
    
}
