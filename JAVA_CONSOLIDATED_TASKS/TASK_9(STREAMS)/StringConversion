import java.util.*;
import java.util.stream.*;

public class StringConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            words.add(sc.nextLine());
        }
        List<String> upper = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> lower = words.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(upper);
        System.out.println(lower);
    }
}
