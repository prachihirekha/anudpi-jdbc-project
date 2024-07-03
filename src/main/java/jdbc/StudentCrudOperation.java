package jdbc;

import java.sql.*;
import java.util.Scanner;

public class StudentCrudOperation {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Register the driver
        Class.forName("org.postgresql.Driver");

        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "prachi20");

        // Create statement object for sending SQL statement to the database
        Statement stm = con.createStatement();
        // Create STUDENT1 table if it does not exist1
        String createTableSql = "CREATE TABLE IF NOT EXISTS STUDENT1 (" +
                "id INT PRIMARY KEY," +
                "first_name VARCHAR(50)," +
                "last_name VARCHAR(50)," +
                "age INT," +
                "grade VARCHAR(10)" +
                ")";
        stm.executeUpdate(createTableSql);
        System.out.println("STUDENT1 table created (if not existed)");
        Scanner sc = new Scanner(System.in);
        int operation;

        do {
            System.out.println("Available operations:");

            System.out.println("1. Insert");
            System.out.println("2. select");
            System.out.println("3. Delete");
            System.out.println("4. Update");
            //System.out.println("5. get one record");
            System.out.println("5. Exit");
            System.out.println("Please enter the action that you want to perform:");
            operation = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            switch (operation) {
                // insert
                case 1:
                    System.out.println("Enter the student's ID:");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter the student's first name:");
                    String firstName = sc.nextLine();
                    System.out.println("Enter the student's last name:");
                    String lastName = sc.nextLine();
                    System.out.println("Enter the student's age:");
                    int age = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter the student's grade:");
                    String grade = sc.nextLine();
                    PreparedStatement pstm = con.prepareStatement("INSERT INTO STUDENT1 (id, first_name, last_name, age, grade) VALUES (?, ?, ?, ?, ?)");
                    pstm.setInt(1, id);
                    pstm.setString(2, firstName);
                    pstm.setString(3, lastName);
                    pstm.setInt(4, age);
                    pstm.setString(5, grade);
                    int rowsInserted = pstm.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new student was inserted successfully!");
                    }
                    pstm.close();
                    break;
// retrive
                case 2:
                    ResultSet rs = stm.executeQuery("SELECT * FROM STUDENT1");
                    System.out.println("Student details:");
                    System.out.println("===============");
                    while (rs.next()) {
                        id = rs.getInt(1);
                        firstName = rs.getString(2);
                        lastName = rs.getString(3);
                        age = rs.getInt(4);
                        grade = rs.getString(5);
                        System.out.println(id + " " + firstName + " " + lastName + " " + age + " " + grade);
                    }
                    rs.close();
                    break;
// delete
                case 3:
                    System.out.println("Enter the student ID to delete:");
                    id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    pstm = con.prepareStatement("DELETE FROM student1 WHERE id = ?");
                    pstm.setInt(1, id);
                    int rowsDeleted = pstm.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("A student was deleted successfully!");
                    }
                    pstm.close();
                    break;
// update

                case 4:
                    System.out.println("Enter the student ID to update:");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter the new first name:");
                    String newFirstName = sc.nextLine();
                    System.out.println("Enter the new last name:");
                    String newLastName = sc.nextLine(); // Corrected to use newLastName instead of newDesignation
                    System.out.println("Enter the new age:");
                    int newAge = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter the new grade:");
                    String newGrade = sc.nextLine();
                    pstm = con.prepareStatement("UPDATE STUDENT1 SET first_name = ?, last_name = ?, age = ?, grade = ? WHERE id = ?");
                    pstm.setString(1, newFirstName);
                    pstm.setString(2, newLastName); // Corrected to use newLastName
                    pstm.setInt(3, newAge);
                    pstm.setString(4, newGrade);
                    pstm.setInt(5, updateId);
                    int rowsUpdated = pstm.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Student with ID " + updateId + " was updated successfully!");
                    } else {
                        System.out.println("No student found with ID " + updateId);
                    }
                    pstm.close();
                    break;


               // case 5:


                case 5:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid operation. Please try again.");
            }
        } while (operation != 5);

        // Close the Statement and Connection
        stm.close();
        con.close();
        sc.close();
    }
}
/*
java application -> database-> mMySql, postgres,oracle
backend language
syntex                      Syntexs
class                       Table
 */
