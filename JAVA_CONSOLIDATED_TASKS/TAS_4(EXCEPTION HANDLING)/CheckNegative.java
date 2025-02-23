import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckNegative {
    static void checkNumbers(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num > 0) {
                throw new Exception("Positive number found: " + num);
            }
        }
        System.out.println("All numbers are negative");
        sc.close();
    }

    public static void main(String[] args) {
        try {
            checkNumbers("C:\\Users\\aarch\\Documents\\numbers.txt");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
