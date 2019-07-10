package daos;

import com.mysql.cj.jdbc.Driver;
import daos.*;
import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/";
    public static final String USER = "root";
    public static final String PASS = "password";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void main(String[] args) {
        YarnDAO dao = new YarnDAO();
//        dao.create(new YarnLabel("wool", "acrylic", YarnLabel.Ply.FOUR, YarnLabel.Weight.ARAN, "red"));
//        YarnLabel label = dao.findById(16);
//        System.out.println(label);
//        label.setColor("red");
//        dao.update(label);
//        System.out.println(label);
        dao.delete(16);
    }
}
