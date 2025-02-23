import java.sql.*;
import java.util.Scanner;

public class EmployeeMenu {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedb";
        String user = "root";
        String password = "aarch@SQL25#N";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select the row");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, name);
                    pstmt.setDouble(2, salary);
                    pstmt.executeUpdate();
                    System.out.println("Employee inserted successfully.");
                } else if (choice == 2) {
                    System.out.print("Enter Employee ID to update: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter new salary: ");
                    double salary = scanner.nextDouble();
                    String sql = "UPDATE employees SET salary = ? WHERE id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setDouble(1, salary);
                    pstmt.setInt(2, id);
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("No employee found with ID: " + id);
                    }
                } else if (choice == 3) {
                    System.out.print("Enter Employee ID to delete: ");
                    int id = scanner.nextInt();
                    String sql = "DELETE FROM employees WHERE id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, id);
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("No employee found with ID: " + id);
                    }
                } else if (choice == 4) {
                    System.out.print("Enter Employee ID to view: ");
                    int id = scanner.nextInt();
                    String sql = "SELECT * FROM employees WHERE id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Salary: " + rs.getDouble("salary"));
                    } else {
                        System.out.println("No employee found with ID: " + id);
                    }
                } else if (choice == 5) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
