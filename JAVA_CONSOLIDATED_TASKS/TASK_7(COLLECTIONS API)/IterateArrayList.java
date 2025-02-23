import java.util.*;

public class IterateArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple"));
        for (String color : colors) {
            System.out.println(color);
        }
    }
}
