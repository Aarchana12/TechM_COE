import java.util.*;

public class InsertAtFront {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Blue", "Green"));
        list.offerFirst("Red");
        System.out.println(list);
    }
}
