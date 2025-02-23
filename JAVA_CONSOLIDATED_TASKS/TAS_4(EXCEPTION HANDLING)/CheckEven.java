import java.util.Scanner;

public class CheckEven {
    static void checkEven(int num) throws OddNumberException {
        if (num % 2 != 0) {
            throw new OddNumberException("Number is odd");
        }
        System.out.println("Number is even");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        sc.close();

        try {
            checkEven(num);
        } catch (OddNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
