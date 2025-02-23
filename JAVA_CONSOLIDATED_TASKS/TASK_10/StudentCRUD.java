import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb3", "root",
                "aarch@SQL25#N");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Insert Row");
            System.out.println("2. Update Row");
            System.out.println("3. Delete Row");
            System.out.println("4. Select Row");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();

                scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Salary: ");
                double salary = scanner.nextDouble();
                PreparedStatement stmt = conn
                        .prepareStatement("INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)");
                stmt.setInt(1, id);
                stmt.setString(2, name);
                stmt.setDouble(3, salary);
                stmt.executeUpdate();
                System.out.println("Row Inserted.");
            } else if (choice == 2) {
                System.out.print("Enter Employee ID to Update: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter New Salary: ");
                double salary = scanner.nextDouble();
                PreparedStatement stmt = conn.prepareStatement("UPDATE employees SET name=?, salary=? WHERE id=?");
                stmt.setString(1, name);

                stmt.setDouble(2, salary);
                stmt.setInt(3, id);
                int rows = stmt.executeUpdate();
                System.out.println(rows > 0 ? "Row Updated." : "No Record Found.");
            } else if (choice == 3) {
                System.out.print("Enter Employee ID to Delete: ");
                int id = scanner.nextInt();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM employees WHERE id=?");
                stmt.setInt(1, id);
                int rows = stmt.executeUpdate();
                System.out.println(rows > 0 ? "Row Deleted." : "No Record Found.");
            } else if (choice == 4) {
                System.out.print("Enter Employee ID to View: ");
                int id = scanner.nextInt();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees WHERE id=?");
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Salary: " + rs.getDouble("salary"));
                } else {
                    System.out.println("No Record Found.");
                }
            } else if (choice == 5) {
                break;
            }
        }
        conn.close();
        scanner.close();
    }
}
