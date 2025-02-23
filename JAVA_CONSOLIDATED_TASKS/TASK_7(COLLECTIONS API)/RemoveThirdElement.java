import java.util.*;

public class RemoveThirdElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple"));
        colors.remove(2);
        System.out.println(colors);
    }
}
