/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.clinic;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import qcare.util.DBHelper;

/**
 *
 * @author HP
 */
public class ClinicDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public ClinicDAO() {
    }

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public List<ClinicDTO> getAll()
            throws NamingException, SQLException {
        List<ClinicDTO> result = null;
        try {
            String sql = "SELECT * FROM tblClinic";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                int ID = rs.getInt("ID");
                String Name = rs.getNString("Name");
                String Address = rs.getNString("Address");
                int City = rs.getInt("City");
                String Phone = rs.getString("Phone");
                Time OpenTime = rs.getTime("OpenTime");
                Time CloseTime = rs.getTime("CloseTime");

                ClinicDTO dto = new ClinicDTO(ID, Name, Address, City, Phone, OpenTime, CloseTime);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ClinicDTO> search(List<String> symptoms)
            throws NamingException, SQLException {
        List<ClinicDTO> result = null;
        String searchValue = "";
        for (String symptom : symptoms) {
            searchValue += "sm.Description LIKE ? OR ";
        }
        searchValue = searchValue.trim();
        searchValue = searchValue.substring(0, searchValue.length() - 3);
        try {
            String sql = "SELECT DISTINCT cnc.* FROM tblClinic cnc "
                    + "JOIN tblHas has "
                    + "ON has.Clinic = cnc.ID "
                    + "JOIN tblSpecialist spe "
                    + "ON spe.ID = has.Specialist "
                    + "JOIN tblBelongs bel "
                    + "ON bel.Specialist = spe.ID "
                    + "JOIN tblSymptom sym "
                    + "ON sym.ID = bel.Symptom "
                    + "WHERE " + searchValue;
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            int count = 1;
            for (String symptom : symptoms) {
                stm.setNString(count, "%" + symptom + "%");
                count++;
            }
            rs = stm.executeQuery();

            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                int ID = rs.getInt("ID");
                String Name = rs.getNString("Name");
                String Address = rs.getNString("Address");
                int City = rs.getInt("City");
                String Phone = rs.getString("Phone");
                Time OpenTime = rs.getTime("OpenTime");
                Time CloseTime = rs.getTime("CloseTime");

                ClinicDTO dto = new ClinicDTO(ID, Name, Address, City, Phone, OpenTime, CloseTime);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
