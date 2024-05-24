package ru.mirea_.rybina_iboldova.jiraf_john;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresDbHelper {

    private static final String URL = "jdbc:postgresql://77.222.36.12:16246/admin";
    private static final String USER = "admin";
    private static final String PASSWORD = "XDJP*KS5PXdHN6NZ";
    private Connection connection;

    public PostgresDbHelper() {
        connect();
    }

    private void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection to PostgreSQL server failed.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean auth(String username) {
        String query = "SELECT 1 FROM users WHERE username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // Method to hash a password
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Method to check if a user exists and verify their password
    public boolean auth(String username, String password) {
        String query = "SELECT password FROM users WHERE username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("password");
                    return BCrypt.checkpw(password, storedHash); // Verify the password
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


//-- Create the users table
//CREATE TABLE users (
//        id SERIAL PRIMARY KEY,
//        username VARCHAR(255) NOT NULL UNIQUE,
//password VARCHAR(255) NOT NULL
//);
//
//        -- Create the unit table
//CREATE TABLE unit (
//        number INT NOT NULL,
//        count_answers INT NOT NULL,
//        user_id INT,
//        FOREIGN KEY (user_id) REFERENCES users(id)
//        );