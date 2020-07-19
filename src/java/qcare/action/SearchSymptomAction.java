/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import qcare.clinic.ClinicDAO;
import qcare.clinic.ClinicDTO;

/**
 *
 * @author HP
 */
public class SearchSymptomAction {

    private String[] Symptoms;
    private String Other;
    private String currentPage;
    private List<ClinicDTO> list;

    private static final String SUCCESS = "success";

    public SearchSymptomAction() {
    }

    public String execute() throws Exception {
        String url = SUCCESS;

        List<String> searchValues = new ArrayList<>();
        searchValues.addAll(Arrays.asList(Symptoms));
        if (!Other.isEmpty() || Other != null) {
            StringTokenizer stk = new StringTokenizer(Other, ",;.");
            while (stk.hasMoreElements()) {
                String token = stk.nextToken();
                if (!searchValues.contains(token)) {
                    searchValues.add(token);
                }
            }
        }

        ClinicDAO clinicDAO = new ClinicDAO();
        list = clinicDAO.search(searchValues);

        return url;
    }

    public String[] getSymptoms() {
        return Symptoms;
    }

    public void setSymptoms(String[] Symptoms) {
        this.Symptoms = Symptoms;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String Other) {
        this.Other = Other;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public List<ClinicDTO> getList() {
        return list;
    }

    public void setList(List<ClinicDTO> list) {
        this.list = list;
    }

}
