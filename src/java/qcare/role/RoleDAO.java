/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.role;

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
public class RoleDAO implements Serializable{

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public List<RoleDTO> getAll() throws NamingException, SQLException {
        List<RoleDTO> result = null;
        try {
            con = DBHelper.makeConnection();
            String sql = "SELECT ID, Name FROM tblRole";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getNString("Name");
                if(result==null){
                    result=new ArrayList<>();
                }
                if (result != null) {
                    result.add(new RoleDTO(id, name));
                }
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
