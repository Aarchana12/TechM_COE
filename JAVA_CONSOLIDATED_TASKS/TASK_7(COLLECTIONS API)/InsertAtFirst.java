import java.util.*;

public class InsertAtFirst {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Blue", "Green", "Yellow", "Purple"));
        colors.add(0, "Red");
        System.out.println(colors);
    }
}
