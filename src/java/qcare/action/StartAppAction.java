/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import qcare.belongs.BelongsDAO;
import qcare.city.CityDAO;
import qcare.clinic.ClinicDAO;
import qcare.comment.CommentDAO;
import qcare.forum.ForumDAO;
import qcare.has.HasDAO;
import qcare.user.UserDAO;
import qcare.role.RoleDAO;
import qcare.specialist.SpecialistDAO;
import qcare.symptom.SymptomDAO;

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
        application.put("SYMPTOM_DAO", new SymptomDAO());
        application.put("BELONGS_DAO", new BelongsDAO());
        application.put("CLINIC_DAO", new ClinicDAO());
        application.put("COMMENT_DAO",new CommentDAO());
        application.put("FORUM_DAO",new ForumDAO());
        application.put("HAS_DAO", new HasDAO());
        return success;
    }

}
