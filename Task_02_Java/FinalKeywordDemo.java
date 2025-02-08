final class FinalClass {
    final int constant = 100;

    final void display() {
        System.out.println("This is a final method");
    }
}

public class FinalKeywordDemo {
    public static void main(String[] args) {
        FinalClass obj = new FinalClass();
        System.out.println("Final Variable: " + obj.constant);
        obj.display();
    }
}
