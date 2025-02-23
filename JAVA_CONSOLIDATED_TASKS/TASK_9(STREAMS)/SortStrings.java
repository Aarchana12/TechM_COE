import java.util.*;
import java.util.stream.*;

public class SortStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            words.add(sc.nextLine());
        }
        List<String> ascending = words.stream().sorted().collect(Collectors.toList());
        List<String> descending = words.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(ascending);
        System.out.println(descending);
    }
}
