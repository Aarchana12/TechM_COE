public class PassByDemo {
    public static void modify(int num, int[] arr) {
        num = 10;
        arr[0] = 10;
    }

    public static void main(String[] args) {
        int num = 5;
        int[] arr = {5};
        modify(num, arr);
        System.out.println("Primitive: " + num);
        System.out.println("Reference: " + arr[0]);
    }
}
