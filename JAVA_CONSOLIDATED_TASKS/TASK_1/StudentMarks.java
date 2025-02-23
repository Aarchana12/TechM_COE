import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(sc.nextLine());
        String[][] students = new String[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks for 3 subjects: ");
            String[] marksStr = sc.nextLine().split(" ");
            int total = 0;
            for (String mark : marksStr) {
                total += Integer.parseInt(mark);
            }
            double average = total / 3.0;
            students[i][0] = name;
            students[i][1] = total + " " + average;
        }

        Arrays.sort(students, (a, b) -> Double.compare(Double.parseDouble(b[1].split(" ")[1]), Double.parseDouble(a[1].split(" ")[1])));

        System.out.println("Sorted list of students based on average marks:");
        for (String[] student : students) {
            System.out.println(student[0] + " Total: " + student[1].split(" ")[0] + " Average: " + student[1].split(" ")[1]);
        }
    }
}
