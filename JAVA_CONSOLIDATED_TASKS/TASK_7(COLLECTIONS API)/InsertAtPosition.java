import java.util.*;

public class InsertAtPosition {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Blue", "Green"));
        list.add(1, "Black");
        System.out.println(list);
    }
}
