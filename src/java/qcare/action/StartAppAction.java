/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import qcare.city.CityDAO;
import qcare.user.UserDAO;
import qcare.role.RoleDAO;
import qcare.specialist.SpecialistDAO;

/**
 *
 * @author DELL
 */
public class StartAppAction {

    private final String success = "success";

    public StartAppAction() {
    }

    public String execute() throws Exception {
        Map application = ActionContext.getContext().getApplication();
        application.put("CITY_DAO", new CityDAO());
        application.put("USER_DAO", new UserDAO());
        application.put("ROLE_DAO", new RoleDAO());
        application.put("SPECIALIST_DAO", new SpecialistDAO());

        return success;
    }

}
