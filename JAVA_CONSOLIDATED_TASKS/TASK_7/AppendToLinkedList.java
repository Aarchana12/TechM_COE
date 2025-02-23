import java.util.*;

public class AppendToLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Blue", "Green"));
        list.add("Yellow");
        System.out.println(list);
    }
}
