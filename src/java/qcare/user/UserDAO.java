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
import javax.naming.NamingException;
import qcare.util.DBHelper;

/**
 *
 * @author HP
 */
public class UserDAO implements Serializable {

    private final boolean STATUS_ACTIVATE = true;
    private final boolean STATUS_INACTIVATE = false;
    private final int ROLE_DOCTOR = 1;
    private final int ROLE_PATIENT = 2;
    private final int ROLE_ADMIN = 2;

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
                int role = rs.getInt("Role");
                boolean gender = rs.getBoolean("Gender");
                int birthyear = rs.getInt("Birthyear");
                boolean accountStatus = rs.getBoolean("AccountStatus");
                int specialist = rs.getInt("specialist");
                result = new UserDTO(Username, Password, name, city, role, gender, birthyear, accountStatus, specialist);
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

    public boolean create(UserDTO dto) throws SQLException, NamingException {
        boolean check = false;

        try {
            String sql = "INSERT INTO (Username, Password, Name, City, Role, Gender, "
                    + "Birthyear, AccountStatus, Specialist) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getUsername());
            stm.setString(2, dto.getPassword());
            stm.setNString(3, dto.getName());
            stm.setInt(4, dto.getCity());
            stm.setInt(5, dto.getRole());
            stm.setBoolean(6, dto.isGender());
            stm.setInt(7, dto.getBirthyear());
            if (dto.getRole() != ROLE_PATIENT) {
                stm.setBoolean(8, STATUS_INACTIVATE);
            } else {
                stm.setBoolean(8, STATUS_ACTIVATE);
            }
            stm.setInt(9, dto.getSpecialist());

            check = stm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }

        return check;
    }
}
