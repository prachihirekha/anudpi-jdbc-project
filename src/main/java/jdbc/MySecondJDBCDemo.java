package jdbc;

import java.sql.*;

public class MySecondJDBCDemo {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        // register the driver
     Class.forName("org.postgresql.Driver");

        // Establish the connection
       Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "prachi20");

        // Create statement object for sending SQL statement to the database
       Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from employee1");//
        int id;
        String name, desig,dept;
        int sal;
        System.out.println("Employee details");
        System.out.println("===============");
        while (rs.next()){
            id=rs.getInt(1);
            name=rs.getString(2);
            desig=rs.getString(3);
            dept=rs.getString(4);
            sal=rs.getInt(5);
            System.out.println(id+ " "+ name+ " "+desig+ " "+dept+" "+sal+ " ");
        }
            con.close();

        //System.out.println(rs);


    }
}
