import java.sql.*;
import java.util.Scanner;

public class DeleteEmployee {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedb";
        String user = "root";
        String password = "aarch@SQL25#N";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Employee ID to delete: ");
            int employeeId = scanner.nextInt();

            String sql = "DELETE FROM employees WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, employeeId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("No employee found with ID: " + employeeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
