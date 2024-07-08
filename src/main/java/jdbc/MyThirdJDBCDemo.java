package jdbc;

import java.sql.*;
import java.util.Scanner;

public class MyThirdJDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "prachi20");
        int id,sal;
        String name,desig, dept;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the emp ID");
        id=sc.nextInt();
        System.out.println("Enter the name");
        name=sc.next();
        System.out.println("Enter the desig");
        desig=sc.next();
        System.out.println("Enter the dept");
        dept=sc.next();
        System.out.println("enter the salary");
        sal=sc.nextInt();
        PreparedStatement pstm =con.prepareStatement("insert into employee1 values(?,?,?,?,?)");
        pstm.setInt(1,id);
        pstm.setString(2,name);
        pstm.setString(3,desig);
        pstm.setString(4,dept);
        pstm.setInt(5,sal);
       int i = pstm.executeUpdate();
       con.close();
        System.out.println(i +" Add the employee");
    }
}

