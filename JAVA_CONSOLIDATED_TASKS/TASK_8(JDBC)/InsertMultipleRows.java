import java.sql.*;
import java.util.Scanner;

public class InsertMultipleRows {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedb?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";

        String password = "aarch@SQL25#N";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO employees (name, salary) VALUES (?, ?)");
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the number of employees: ");
            int count = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < count; i++) {
                System.out.print("Enter employee name: ");
                String name = scanner.nextLine();
                System.out.print("Enter employee salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();

                stmt.setString(1, name);
                stmt.setDouble(2, salary);
                stmt.executeUpdate();
            }

            System.out.println("Employees inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
