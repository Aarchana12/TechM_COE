import java.util.*;

class DemoSet {
    public static void main(String[] args) {
        // HashSet with Integer values
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(5);
        hashSet.add(20);
        hashSet.add(15);
        hashSet.add(10);
        System.out.println("HashSet (Integer): " + hashSet);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Banana");
        System.out.println("LinkedHashSet (String): " + linkedHashSet);


        TreeSet<Float> treeSet = new TreeSet<>();
        treeSet.add(10.5f);
        treeSet.add(5.2f);
        treeSet.add(20.3f);
        treeSet.add(15.8f);
        treeSet.add(10.5f);
        System.out.println("TreeSet (Float): " + treeSet);
    }
}
