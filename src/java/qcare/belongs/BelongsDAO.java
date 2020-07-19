/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.belongs;

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
public class BelongsDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public List<BelongsDTO> getAll() throws NamingException, SQLException {
        List<BelongsDTO> result = null;
        try {
            con = DBHelper.makeConnection();
            String sql = "SELECT * FROM tblBelongs";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int spec = rs.getInt("Specialist");
                int symptom = rs.getInt("Symptom");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new BelongsDTO(spec, symptom));
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
