public class TrailingZeroes {
    public static int findTrailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 100;
        System.out.println("Trailing Zeroes: " + findTrailingZeroes(num));
    }
}
