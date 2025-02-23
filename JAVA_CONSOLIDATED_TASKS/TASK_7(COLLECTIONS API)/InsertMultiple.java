import java.util.*;

public class InsertMultiple {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Green"));
        list.addAll(1, Arrays.asList("Blue", "Yellow"));
        System.out.println(list);
    }
}
