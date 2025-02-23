
import java.util.Scanner;

public class AlternateCapitalization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine().trim();

        if (str.isEmpty()) {
            System.out.println("Input cannot be empty");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        System.out.println("Output: " + sb.toString());
    }
}
