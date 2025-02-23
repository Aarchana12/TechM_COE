import java.util.List;

class GenericSearch {
    static <T> int findIndex(List<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        System.out.println(findIndex(names, "Bob"));
        System.out.println(findIndex(names, "David"));
    }
}
