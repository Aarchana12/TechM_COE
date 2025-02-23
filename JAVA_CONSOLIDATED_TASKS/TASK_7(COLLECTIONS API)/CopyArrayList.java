import java.util.*;

public class CopyArrayList {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("Red", "Blue", "Green"));
        ArrayList<String> list2 = new ArrayList<>(list1);
        System.out.println(list2);
    }
}
