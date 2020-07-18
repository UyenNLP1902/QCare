/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.action;

import javax.naming.NamingException;

/**
 *
 * @author HP
 */
public class CreateAction {

    private String Username;
    private String Password;
    private String Name;
    private String City;
    private String Role;
    private String Gender;
    private String Birthyear;
    private String Specialist;

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public CreateAction() {
    }

    public String execute() throws Exception {
        try {
            
            AccountDTO dto = new AccountDTO(email, password, name, phoneNum, address);
            AccountDAO dao = new AccountDAO();
            boolean created = dao.createAccount(dto);

            if (created) {
                String code = EmailHelper.getRandomActivationCode();
                ActivationDAO activationDAO = new ActivationDAO();
                boolean check = activationDAO.insertActivationCode(dto, code);

                if (check) {
                    EmailHelper eh = new EmailHelper();
                    eh.setToEmail(dto.getEmail());
                    eh.sendEmail(code);
                    url = SUCCESS;
                }
            }
        } catch (NamingException ex) {
            //log.error(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet.");
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

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getBirthyear() {
        return Birthyear;
    }

    public void setBirthyear(String Birthyear) {
        this.Birthyear = Birthyear;
    }

    public String getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(String Specialist) {
        this.Specialist = Specialist;
    }

}
