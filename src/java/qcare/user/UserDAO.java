/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class UserDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public UserDAO() {
    }

    public UserDTO checkLogin(String Username, String Password) throws SQLException {
        UserDTO result = null;
        try {
            //con = getConnection();
            String sql = "SELECT Name, City, Role, Gender, Birthyear, "
                    + "AccountStatus, Specialist FROM tblUser WHERE "
                    + "Username = ? AND Password = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, Username);
            stm.setString(2, Password);
            rs = stm.executeQuery();
            if (rs.next()) {
                String name = rs.getNString("Name");
                int city = rs.getInt("City");
                String role = rs.getNString("Role");
                boolean gender = rs.getBoolean("Gender");
                int birthyear = rs.getInt("Birthyear");
                boolean accountStatus = rs.getBoolean("AccountStatus");
                String specialist = rs.getNString("specialist");
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
