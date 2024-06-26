package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstDemo {
        public static void main(String[] args) {
        Connection con = null;
        Statement stm = null;

        try {
            // Register the driver
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "prachi20");

            // Create statement object for sending SQL statement to the database
            stm = con.createStatement();

            // Execute update statement
            stm.executeUpdate("INSERT INTO employee1 VALUES (5, 'Rama', 'manager', 'CS', 2134000)");
            System.out.println("Employee added successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (stm != null) stm.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

