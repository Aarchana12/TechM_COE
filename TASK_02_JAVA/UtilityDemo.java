public class UtilityDemo {
    public static void main(String[] args) {
        int number = 12345;
        System.out.println("Length of number: " + Utility.getLength(number));
    }
}

class Utility {
    public static int getLength(int number) {
        return String.valueOf(number).length();
    }
}
