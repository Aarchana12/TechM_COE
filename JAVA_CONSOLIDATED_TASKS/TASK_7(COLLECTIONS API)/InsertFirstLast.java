import java.util.*;

public class InsertFirstLast {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Blue", "Green"));
        list.addFirst("Red");
        list.addLast("Yellow");
        System.out.println(list);
    }
}
