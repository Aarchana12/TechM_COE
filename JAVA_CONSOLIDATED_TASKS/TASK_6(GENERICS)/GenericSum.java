import java.util.List;

class GenericSum {
    static <T extends Number> int sumEvenOdd(List<T> list, boolean even) {
        int sum = 0;
        for (T num : list) {
            if ((num.intValue() % 2 == 0) == even)
                sum += num.intValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(sumEvenOdd(nums, true));
        System.out.println(sumEvenOdd(nums, false));
    }
}
