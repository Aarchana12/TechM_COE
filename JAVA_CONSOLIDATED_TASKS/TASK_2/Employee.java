import java.util.Scanner;

public class Employee {
    int empId;
    String empName;
    double sal;
    int yearsWorked;

    void setEmployeeDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        empId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        empName = sc.nextLine();
        System.out.print("Enter Monthly Salary: ");
        sal = sc.nextDouble();
        System.out.print("Enter Years Worked: ");
        yearsWorked = sc.nextInt();
    }

    void getEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Annual Salary: " + (sal * 12));
        System.out.println("Years Worked: " + yearsWorked);
    }

    void getLoanEligibility() {
        if (yearsWorked <= 5) {
            System.out.println("Not eligible for loan");
            return;
        }
        double annualSalary = sal * 12;
        if (annualSalary >= 15_00_000) {
            System.out.println("Eligible for Loan: 7 Lakhs");
        } else if (annualSalary >= 10_00_000) {
            System.out.println("Eligible for Loan: 5 Lakhs");
        } else if (annualSalary >= 6_00_000) {
            System.out.println("Eligible for Loan: 2 Lakhs");
        } else {
            System.out.println("Not eligible for loan");
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setEmployeeDetails();
        emp.getEmployeeDetails();
        emp.getLoanEligibility();
    }
}
