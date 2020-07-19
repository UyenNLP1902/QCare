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

/**
 *
 * @author HP
 */
public class SearchSymptomAction {

    private String[] Symptoms;
    private String Other;
    private String currentPage;

    private static final String SUCCESS = "success";

    public SearchSymptomAction() {
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        StringTokenizer stk = null;

        List<String> searchValues = new ArrayList<>();
        searchValues.addAll(Arrays.asList(Symptoms));
        if (Other != null) {
            stk = new StringTokenizer(Other, ",;.");
            while (stk.hasMoreElements()) {

            }
        }
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

}
