import java.util.*;
import java.util.stream.*;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println(average);
    }
}
