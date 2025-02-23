import java.util.*;

public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple"));
        Collections.sort(colors);
        System.out.println(colors);
        Collections.sort(colors, Collections.reverseOrder());
        System.out.println(colors);
    }
}
