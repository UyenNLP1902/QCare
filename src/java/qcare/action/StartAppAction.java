/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import qcare.city.CityDAO;
import qcare.user.UserDAO;

/**
 *
 * @author DELL
 */
public class StartAppAction {

    private final String success = "success";

    public StartAppAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CityDAO cityDAO = new CityDAO();
        session.put("CITY_DAO", cityDAO);
        UserDAO userDao = new UserDAO();
        session.put("USER_DAO", userDao);
        return success;
    }

}
