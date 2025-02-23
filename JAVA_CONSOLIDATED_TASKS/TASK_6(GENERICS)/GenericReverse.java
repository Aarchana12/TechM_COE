import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class GenericReverse {
    static <T> List<T> reverseList(List<T> list) {
        List<T> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.println(reverseList(nums));
    }
}
