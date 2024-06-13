package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx {
    public static void main(String[] args) {
      try{
          Class.forName("org.postgresql.Driver");// load  the file
          // connetion
          Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres\",\"postgres\", \"prachi20");
          if(con.isClosed()){
              System.out.println("connection is closer");
          }
          else{
              System.out.println("connection is created....." );
          }
      } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    }
}
