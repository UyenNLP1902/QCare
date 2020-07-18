/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcare.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CityDAO {
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    
    public List<CityDTO> getAll() throws SQLException, SQLException{
        List<CityDTO> result =null;
        try{
            con = DBH;
            String sql = "SELECT Postcode, Name FROM tblCity";
            stm=con.prepareStatement(sql);
            rs=stm.executeQuery();
            while(rs.next()){
                int code = rs.getInt("Postcode");
                String name = rs.getNString("Name");
                CityDTO city = new CityDTO(code, name);
                result.add(city);
            }
        }finally{
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
