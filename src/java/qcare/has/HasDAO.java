/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.has;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import qcare.util.DBHelper;

/**
 *
 * @author DELL
 */
public class HasDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public HasDAO() {
    }

    public List<HasDTO> getAll() throws NamingException, SQLException {
        List<HasDTO> result = null;
        try {
            con = DBHelper.makeConnection();
            String sql = "SELECT Clinic, Specialist FROM tblSymptom";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int clinic = rs.getInt("Clinic");
                int spec = rs.getInt("Specialist");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new HasDTO(clinic, spec));
            }
        } finally {
            closeConnection();
        }
        return result;
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
}
