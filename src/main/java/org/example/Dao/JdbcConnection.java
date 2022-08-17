package org.example.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


//Setting up the connection
public class JdbcConnection {
    private static final Logger LOGGER =
            Logger.getLogger(JdbcConnection.class.getName());
    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://localhost:5432/rpa";
        String user = "postgres";

        String password = "12345";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
