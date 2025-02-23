import java.util.*;

public class ShuffleArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple"));
        Collections.shuffle(colors);
        System.out.println(colors);
    }
}
