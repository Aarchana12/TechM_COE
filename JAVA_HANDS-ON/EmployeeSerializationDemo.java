import java.io.*;

class Employee implements Serializable {
    int eno;
    String ename;
    transient String email;

    Employee(int eno, String ename, String email) {
        this.eno = eno;
        this.ename = ename;
        this.email = email;
    }
}

public class EmployeeSerializationDemo {
    public static void main(String[] args) {
        // Serialize the Employee object
        try {
            Employee emp = new Employee(101, "John Doe", "john.doe@example.com");
            FileOutputStream fos = new FileOutputStream("employee.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            oos.close();
            fos.close();
            System.out.println("Serialization completed.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e);
        }

        try {
            FileInputStream fis = new FileInputStream("employee.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Employee emp = (Employee) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Deserialization completed.");
            System.out.println("Employee Details:");
            System.out.println("Eno: " + emp.eno);
            System.out.println("Ename: " + emp.ename);
            System.out.println("Email: " + emp.email);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e);
        }
    }
}
