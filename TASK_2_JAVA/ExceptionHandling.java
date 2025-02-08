import java.util.Scanner;

public class ExceptionHandling {
    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();
            System.out.println("Reciprocal: " + (1 / num));
        } catch (Exception e) {
            System.out.println("Invalid input or division by zero");
        }
    }

    public static void main(String[] args) {
        processInput();
    }
}
