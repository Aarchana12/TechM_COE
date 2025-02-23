import java.util.Arrays;

public class EqualsVsDeepEquals {
    public static void main(String[] args) {
        String[] arr1 = {"one", "two", "three"};
        String[] arr2 = {"one", "two", "three"};
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.deepEquals(arr1, arr2));
    }
}
