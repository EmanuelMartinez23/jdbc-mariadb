package org.devemanuel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String jdbcUrl = "jdbc:mariadb://localhost:3306/world";
    private static final String username = "basesdedatos";
    private static final String password = "pharsa13";

    public static Connection getConnection() {
        Connection connection;
        try{
            connection = DriverManager.getConnection(jdbcUrl,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}
