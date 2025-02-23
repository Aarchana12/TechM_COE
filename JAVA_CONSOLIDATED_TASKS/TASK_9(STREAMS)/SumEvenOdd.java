import java.util.*;
import java.util.stream.*;

public class SumEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
        int evenSum = numbers.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum();
        int oddSum = numbers.stream().filter(x -> x % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println(evenSum);
        System.out.println(oddSum);
    }
}
