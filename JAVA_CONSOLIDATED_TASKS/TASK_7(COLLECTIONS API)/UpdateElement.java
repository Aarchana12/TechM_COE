import java.util.*;

public class UpdateElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple"));
        colors.set(1, "Black");
        System.out.println(colors);
    }
}
