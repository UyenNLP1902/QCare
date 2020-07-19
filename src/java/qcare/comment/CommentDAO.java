/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.comment;

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
public class CommentDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public CommentDAO() {
    }

    public List<CommentDTO> getAll() throws NamingException, SQLException {
        List<CommentDTO> result = null;
        try {
            con = DBHelper.makeConnection();
            String sql = "SELECT * FROM tblComment";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String msg = rs.getNString("MsgContent");
                int preID = rs.getInt("PreviousID");
                String au = rs.getString("Author");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new CommentDTO(id, msg, preID, au));
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
