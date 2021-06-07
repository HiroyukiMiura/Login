package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.beans.Beans;

public class Dao {

    final String jdbcId = "root";
    final String jdbcPass = "password";
    final String jdbcUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=JST";

    public Beans findAccount(Beans b) {

        Beans returnB = new Beans();

        try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {

            String sql = "SELECT loginId, pass, name, roleId FROM account WHERE loginId = ? AND pass = ?";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, b.getUserId());
            ps.setString(2, b.getPassword());

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                returnB.setUserId(rs.getString("userId"));
                returnB.setPassword(rs.getString("password"));
                returnB.setName(rs.getString("name"));
            } else {
                return null;
            }

            con.close();
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return returnB;
    }
}
