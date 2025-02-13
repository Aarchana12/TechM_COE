import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(35);
        list1.add(23);
        list1.add(67);
        list1.add(82);
        list1.add(56);
        list1.add(49);
        list1.add(49);
        list1.add(49);

        System.out.println("Number of elements in the list: " + list1.size());

        list1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is: " + list1);
        System.out.println("The number of elements in the list: " + list1.size());

        System.out.println("Is 566 available in the list: " + list1.contains(566));
        System.out.println("The given list before removing elements is: " + list1);

        list1.remove(2);
        list1.remove(3);
        System.out.println("After removing elements:");
        System.out.println("The given list is: " + list1);
        System.out.println("The number of elements in the list: " + list1.size());
    }
}
