import java.util.*;

class SetSampleTestClass {
    public static void main(String a[]) {

        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(7, 14, 21, 28, 35, 42, 49, 56));
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList("Apple", "Mango", "Peach", "Grape", "Plum", "Lemon", "Kiwi", "Berry"));
        TreeSet<Float> treeSet = new TreeSet<>(Arrays.asList(10.5f, 5.2f, 20.3f, 15.8f, 18.1f, 2.4f, 7.6f, 22.0f));

        setSample(hashSet);
        setSample(linkedHashSet);
        setSample(treeSet);
    }

    public static void setSample(HashSet<Integer> hs) {
        System.out.println("HashSet (Integer): " + hs);
        hs.remove(7);
        System.out.println("After removal: " + hs);
        System.out.print("Numbers divisible by 7: ");
        for (int num : hs) {
            if (num % 7 == 0) System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void setSample(LinkedHashSet<String> hs) {
        System.out.println("LinkedHashSet (String): " + hs);
        hs.remove("Apple");
        System.out.println("After removal: " + hs);
        System.out.print("Strings with max 5 characters: ");
        for (String str : hs) {
            if (str.length() <= 5) System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void setSample(TreeSet<Float> hs) {
        System.out.println("TreeSet (Float): " + hs);
        hs.remove(5.2f);
        System.out.println("After removal: " + hs);
        System.out.print("Elements max of 20: ");
        for (float num : hs) {
            if (num <= 20) System.out.print(num + " ");
        }
        System.out.println();
    }
}
