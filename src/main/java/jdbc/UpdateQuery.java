package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load the PostgreSQL driver
        Class.forName("org.postgresql.Driver");

        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "prachi20");

        // Create the SQL update query
        String sql = "UPDATE employee1 SET name = ?, desig = ?, dept = ?, sal = ? WHERE id = ?";

        // Create a PreparedStatement object
        PreparedStatement ps = con.prepareStatement(sql);

        // Set the values for the placeholders (?)
        ps.setString(1, "Ramesh");  // Set name
        ps.setString(2, "manager");  // Set designation
        ps.setString(3, "HR");  // Set department
        ps.setInt(4, 4698543);  // Set salary
        ps.setInt(5, 2);  // Set id (condition)

        // Execute the update
        int ra = ps.executeUpdate();
        System.out.println("Rows affected: " + ra);

        // Close the PreparedStatement and Connection
        ps.close();
        con.close();
    }
}
