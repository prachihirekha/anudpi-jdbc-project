package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load the PostgreSQL driver
        Class.forName("org.postgresql.Driver");

        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "prachi20");
      String sql = "DELETE FROM employee1 WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,4);
         int rowDeleted =ps.executeUpdate();
         if(rowDeleted>0){
             System.out.println("A row is delete successfully");

         }
        ps.close();
        con.close();
    }
}
