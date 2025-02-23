import java.util.*;
import java.util.stream.*;

public class CountStartsWith {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(sc.nextLine());
        }
        long count = words.stream().filter(s -> s.startsWith(String.valueOf(ch))).count();
        System.out.println(count);
    }
}
