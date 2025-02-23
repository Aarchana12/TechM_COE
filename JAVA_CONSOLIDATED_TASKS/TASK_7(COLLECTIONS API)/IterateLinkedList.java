import java.util.*;

public class IterateLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Blue", "Green"));
        for (String color : list) {
            System.out.println(color);
        }
    }
}
