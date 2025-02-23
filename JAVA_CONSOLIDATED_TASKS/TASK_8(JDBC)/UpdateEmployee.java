import java.sql.*;
import java.util.Scanner;

public class UpdateEmployee {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedb"; // Database URL
        String user = "root"; // MySQL Username
        String password = "aarch@SQL25#N"; // MySQL Password

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Employee ID to update salary: ");
            int empId = scanner.nextInt();

            System.out.print("Enter new salary: ");
            double newSalary = scanner.nextDouble();

            String query = "UPDATE employees SET salary = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setDouble(1, newSalary);
                pstmt.setInt(2, empId);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Employee salary updated successfully!");
                } else {
                    System.out.println("Employee ID not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
