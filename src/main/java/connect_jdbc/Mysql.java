package connect_jdbc;

import enums.Tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {

    private Connection connection = null;
    private final String url = "jdbc:mysql://localhost:3306/db_cac";
    private final String user = "root";
    private final String password = "1234";
    private final String db = "FARHFFX7Tb";
    private final String urlWeb = "jdbc:mysql://remotemysql.com:3306/" + db;
    private final String userWeb = "FARHFFX7Tb";
    private final String passwordWeb = "RBopOWqW37";

    public Mysql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //connection = DriverManager.getConnection(url, user, password);
            connection = DriverManager.getConnection(urlWeb, userWeb, passwordWeb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
