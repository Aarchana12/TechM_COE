import java.util.Arrays;

public class AlternativeElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] result = new int[(arr.length + 1) / 2];
        int j = 0;
        for (int i = 0; i < arr.length; i += 2) {
            result[j++] = arr[i];
        }
        System.out.println(Arrays.toString(result));
    }
}
