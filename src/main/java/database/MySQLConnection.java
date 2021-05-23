package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getConnection()
            throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        // Database name to access
        String dbName = "coursesdb";
        String dbUsername = "root";
        String dbPassword = "root";

        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL + dbName + "?useUnicode=yes&characterEncoding=UTF-8",
                dbUsername,
                dbPassword);
    }
}