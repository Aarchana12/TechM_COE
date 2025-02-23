import java.util.*;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Red", "Blue", "Green", "Blue", "Yellow"));
        System.out.println(list.indexOf("Blue"));
        System.out.println(list.lastIndexOf("Blue"));
    }
}
