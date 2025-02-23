import java.util.*;

public class InsertAtEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Blue"));
        list.offerLast("Green");
        System.out.println(list);
    }
}
